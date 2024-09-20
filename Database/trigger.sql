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

