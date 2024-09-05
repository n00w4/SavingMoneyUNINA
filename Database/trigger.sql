-- Questo file riporta tutti i trigger necessari per il database

-- 1) typeCard: prima di inserire una nuova carta, controllo se il plafond è NULL per una debitCard e se non è NULL per una creditCard.

CREATE OR REPLACE FUNCTION smu.typeCardTrigger() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.typeCard = 'debitCard' AND NEW.plafond IS NOT NULL THEN
        RAISE EXCEPTION 'ERROR: Plafond must be NULL for debitCard';
    END IF;
    IF NEW.typeCard = 'creditCard' AND NEW.plafond IS NULL THEN
        RAISE EXCEPTION 'ERROR: Plafond must NOT be NULL for creditCard';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER checkTypeCardTrigger
BEFORE INSERT ON smu.Card
FOR EACH ROW EXECUTE FUNCTION smu.typeCardTrigger();

-- TESTING
-- INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, ibanBankAccount) VALUES ('1234567890123499', '123', '2029-03-01', 5000, 'debitCard', 'IT12A1234567890123456789067');
-- INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, ibanBankAccount) VALUES ('1234567890123499', '123', '2029-03-01', NULL, 'creditCard', 'IT12A1234567890123456789067');


-- 2) typeTransaction: prima di inserire una nuova transazione, controllo se il tipo di transazione è income (receiver = NULL) o expense (sender = NULL).

CREATE OR REPLACE FUNCTION smu.typeTransactionTrigger() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.typeTransaction = 'income' AND NEW.receiver IS NOT NULL THEN
        RAISE EXCEPTION 'ERROR: Receiver must be NULL for income';
    END IF;
    IF NEW.typeTransaction = 'expense' AND NEW.sender IS NOT NULL THEN
        RAISE EXCEPTION 'ERROR: Sender must be NULL for expense';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER checkTypeTransactionTrigger
BEFORE INSERT ON smu.Transaction
FOR EACH ROW EXECUTE FUNCTION smu.typeTransactionTrigger();

-- TESTING
-- INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction) VALUES (100, 'test', '2022-01-01', 'test', NULL, 'income');
-- INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction) VALUES (100, 'test', '2022-01-01', NULL, 'test', 'expense');

-- 3) checkPortfolioName: prima di inserire un nuovo portfolio, controllo se il nome del portfolio è univoco per l'utente.
CREATE OR REPLACE FUNCTION checkPortfolioName()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM smu.Portfolio
        WHERE name = NEW.name
        AND taxCode = NEW.taxCode
    ) THEN
        RAISE EXCEPTION 'Il nome del portfolio "%" esiste già per questo utente', NEW.name;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER checkPortfolioNameTrigger
BEFORE INSERT OR UPDATE
ON smu.Portfolio
FOR EACH ROW
EXECUTE FUNCTION checkPortfolioName();

--4)checkBalanceCard: Se balanceCard di Card è uguale a 0, il suo valore sarà quello di plafond. Quest'ultimo verrà posto di conseguenza a 0.

CREATE OR REPLACE FUNCTION smu.checkBalanceCard() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.balanceCard = 0 AND NEW.plafond IS NOT NULL THEN
        NEW.balanceCard = NEW.plafond;
	NEW.plafond = 0;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER checkInsertBalanceCard
BEFORE INSERT ON smu.Card
FOR EACH ROW EXECUTE FUNCTION smu.checkBalanceCard();

/*TESTING
Inserimento di una Card con balanceCard = 0 e plafond non NULL
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, plafond) VALUES ('1234567890123456', '123', '2026-12-31', 'IT60X0542811101000000123456', 0, 5000);
Inserimento di una Card con balanceCard diverso da 0
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, plafond) VALUES ('1234567890123457', '123', '2026-12-31', 'IT60X0542811101000000123457', 1000, 5000);
*/

--5)checkValidAmount: L'amount di una Transaction non può essere maggiore del balance della Card che ha effettuato la transazione.

CREATE OR REPLACE FUNCTION smu.checkValidAmount() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.amount > NEW.balance THEN
        RAISE EXCEPTION 'ERROR: Transaction amount cannot be greater than the card balance';
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER checkTransactionAmount
BEFORE INSERT ON smu.Transaction 
FOR EACH ROW EXECUTE FUNCTION smu.checkValidAmount();

/*TESTING
Inserimento di una transazione con un importo inferiore o uguale al saldo della carta
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (100, 'Valid Transaction', '2024-01-01', '1234567890123456', NULL, 'income');
Inserimento di una transazione con un importo maggiore del saldo della carta
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (6000, 'Invalid Transaction', '2024-01-01', '1234567890123456', NULL, 'income');
*/

--6)checkPlafondDebitCard: Se l'attributo plafond di Card è NULL, la transazione sarà automaticamnete uguale a balance del BankAccount associato.


CREATE OR REPLACE FUNCTION smu.checkPlafondDebitCard() RETURNS TRIGGER AS
$$
DECLARE
	bankAccountBalance NUMERIC;
BEGIN
    IF NEW.plafond IS NULL THEN
        SELECT balance INTO bankAccountBalance
        FROM smu.BankAccount
        WHERE iban = NEW.ibanBankAccount;

	NEW.amount = bankAccountBalance;
    END IF;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER checkAndSetTransactionAmount
BEFORE INSERT ON smu.Transaction 
FOR EACH ROW EXECUTE FUNCTION smu.checkPlafondDebitCard();

/*TESTING
Supponiamo di avere i seguenti dati nella tabella BankAccount:
INSERT INTO smu.BankAccount(iban, balance)
VALUES ('IT60X0542811101000000123456', 2000),
       ('IT60X0542811101000000123457', 5000);
E nella tabella Card:
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, plafond, ibanBankAccount)
VALUES ('1234567890123456', '123', '2026-12-31', 'IT60X0542811101000000123456', 1000, NULL, 'IT60X0542811101000000123456'),
       ('1234567890123457', '123', '2026-12-31', 'IT60X0542811101000000123457', 1000, 3000, 'IT60X0542811101000000123457');

Transazione associata alla prima carta (plafond è NULL, quindi l'importo della transazione dovrebbe essere impostato a 2000)
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (0, 'Transaction with NULL plafond', '2024-01-01', '1234567890123456', NULL, 'expense');

Verifica se il trigger ha impostato amount a 2000
SELECT * FROM smu.Transaction WHERE description = 'Transaction with NULL plafond';

Transazione associata alla seconda carta (plafond non è NULL, quindi l'importo della transazione rimane invariato)
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (500, 'Transaction with non-NULL plafond', '2024-01-01', '1234567890123457', NULL, 'expense');

Verifica i risultati
SELECT * FROM smu.Transaction WHERE description = 'Transaction with non-NULL plafond';
*/

--7)expireDateWhenTransaction: Quando viene inserita una Transaction, se effettuata con Card, deve essere valida al momento della transazione.

CREATE OR REPLACE FUNCTION smu.expireDateWhenTransaction() RETURNS TRIGGER AS
$$
DECLARE 
	cardExpiration DATE;
	currentDate DATE = CURRENT_DATE;
BEGIN

    SELECT expitationDate INTO cardExpiration
    From smu.Card
    WHERE cardNumber = NEW.cardNumber;

    IF cardExpiration < currentDate THEN
        RAISE EXCEPTION 'ERROR: The card used for the transaction is expired';
    END IF;

END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER expireDate
BEFORE INSERT ON smu.Transaction 
FOR EACH ROW EXECUTE FUNCTION smu.expireDateWhenTransaction();

/*TESTING
Dati nella tabella Card
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, plafond, ibanBankAccount)
VALUES 
('1234567890123456', '123', '2023-12-31', 'IT60X0542811101000000123456', 1000, NULL, 'IT60X0542811101000000123456'),
('1234567890123457', '123', '2022-12-31', 'IT60X0542811101000000123457', 1000, NULL, 'IT60X0542811101000000123457');

Transazione con carta valida (expirationDate: 2023-12-31)
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (100, 'Transaction with valid card', '2023-11-01', '1234567890123456', NULL, 'expense');

Verifica i risultati
SELECT * FROM smu.Transaction WHERE description = 'Transaction with valid card';

Transazione con carta scaduta (expirationDate: 2022-12-31)
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, source, typeTransaction)
VALUES (100, 'Transaction with expired card', '2024-01-01', '1234567890123457', NULL, 'expense');
*/

--8)checkTransactionFamily: Una transazione di un Portfolio familiare può essere eseguita solo da una carta di un componente di quella stessa famiglia.

CREATE OR REPLACE FUNCTION smu.checkTransactionFamily() RETURNS TRIGGER AS
$$
DECLARE 
	portfolioFamilyId INTEGER;
        cardFamilyId INTEGER;
BEGIN

    SELECT p.idFamily INTO portfolioFamilyId
    FROM smu.Portfolio p
    WHERE p.idPortfolio = NEW.idPortfolio;

    SELECT idFamily INTO portfolioFamilyId
    From smu.Card c
    JOIN smu.BankAccount b ON b.ibanBankAccount = c.ibanBankAccount
    JOIN smu.User u ON u.taxCode = b.taxCode
    WHERE c.cardNumber = NEW.cardNumber;

    IF portfolioFamilyId <> cardFamilyId THEN
        RAISE EXCEPTION 'ERROR: The card used for the transaction must belong to a family member of the same family as the portfolio';
    END IF;

    RETURN NEW;


END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER transactionFamily
BEFORE INSERT ON smu.Transaction 
FOR EACH ROW EXECUTE FUNCTION smu.checkTransactionFamily();

--Testing
-- Dati nella tabella Family
INSERT INTO smu.Family(familyName) VALUES ('Rossi'), ('Bianchi');

--Dati nella tabella Category
INSERT INTO smu.Category(name, keyword) VALUES('spese casa', 'casa')


-- Dati nella tabella Portfolio
INSERT INTO smu.Portfolio(name, description, taxCode, idFamily, keyword) VALUES ('Portfolio Rossi', 'spese per la casa', 'RSSMRA90D15H501U', 1, 'casa'), ('Portfolio Bianchi', 'spese per la macchina', 'BNCHGL85B68F205X', 2, 'macchina');

-- Dati nella tabella User
//INSERT INTO smu.User(firstName, secondName, username, password, email, taxCode, //birthdate, idFamily) VALUES ('user1', 'Mario Rossi', 1), ('user2', 'Luigi Bianchi', 2);

-- Dati nella tabella Card
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, balanceCard, plafond, typeCard, ibanBankAccount) VALUES 
('1234567890123456', '123', '2025-12-31', 'IT60X0542811101000000123456', 1000, 500, 'creditCard', 'IT60X0542811101000000123478'),
('1234567890123457', '124', '2025-12-31', 'IT60X0542811101000000123457', 1000, 500, 'creditCard', 'IT60X0542811101000000123307');

-- Inserimento di una transazione valida, dove la carta appartiene alla stessa famiglia del portfolio
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, sender, typeTransaction, cardNumber, idPortfolio) 
VALUES (300, 'affitto', '2024-08-01', 'user4', NULL, 'expense', '1234567890123457', 2);

-- Inserimento di una transazione non valida, dove la carta NON appartiene alla stessa famiglia del portfolio
INSERT INTO smu.Transaction(idTransaction, amount, description, dateTime, receiver, sender, typeTransaction, cardNumber, idPortfolio) 
VALUES (2, 300, 'affitto', '2024-08-01', 'user4', NULL, 'expense', '1234567890123456', 2);
