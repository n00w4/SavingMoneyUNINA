-- Questo file riporta tutti i trigger necessari per il database

-- 1) typeCard: prima di inserire una nuova carta, controllo se il plafond è NULL per una debitCard e se non è NULL per una creditCard

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


-- 2) typeTransaction: prima di inserire una nuova transazione, controllo se il tipo di transazione è income (receiver = NULL) o expense (source = NULL)

CREATE OR REPLACE FUNCTION smu.typeTransactionTrigger() RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.typeTransaction = 'income' AND NEW.receiver IS NOT NULL THEN
        RAISE EXCEPTION 'ERROR: Receiver must be NULL for income';
    END IF;
    IF NEW.typeTransaction = 'expense' AND NEW.source IS NOT NULL THEN
        RAISE EXCEPTION 'ERROR: Source must be NULL for expense';
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

