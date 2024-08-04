-- In questo file è riportata la creazione del database

-- Creazione schema
DROP SCHEMA IF EXISTS smu CASCADE;
CREATE SCHEMA smu;

-- Table Family
CREATE TABLE smu.Family (
    idFamily INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    familyName VARCHAR(50) NOT NULL
);

-- Table User
CREATE TABLE smu.User (
	firstName VARCHAR(50) NOT NULL,
	secondName VARCHAR(50) NOT NULL,
	username VARCHAR(255) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	taxCode CHAR(16) PRIMARY KEY,
	birthDate DATE NOT NULL,
	idFamily INTEGER REFERENCES smu.Family(idFamily),

	CONSTRAINT checkBirthDateUser CHECK ((birthDate < CURRENT_DATE)),
    CONSTRAINT checkValidEmail CHECK (email ~ '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'),
    CONSTRAINT checkValidTaxCode CHECK (taxCode ~ '^[A-Z]{6}[0-9]{2}[A-EHLMPR-T][0-9]{2}[A-Z][0-9]{3}[A-Z]$'),
    CONSTRAINT checkValidPasswd CHECK (password ~ '^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$')
);

-- Table BankAccount
CREATE TABLE smu.BankAccount (
    bankName VARCHAR(100) NOT NULL,
	balance NUMERIC(12,2) NOT NULL DEFAULT 0,
	ibanBankAccount CHAR(27) PRIMARY KEY,
    taxCode CHAR(16) REFERENCES smu.User(taxCode),

    CONSTRAINT checkValidIBAN CHECK (iban ~ '[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{5}[0-9]{5}[0-9A-Z]{5}')
);

-- Tipo E_CARD per gestire la differenza tra carte di credito e carte di debito
CREATE TYPE E_CARD AS ENUM ('creditCard', 'debitCard');

-- Table Card
CREATE TABLE smu.Card (
    cardNumber CHAR(16) PRIMARY KEY,
    cvv CHAR(3) NOT NULL,
    expirationDate DATE NOT NULL,
    ibanCard CHAR(27) NOT NULL,
    balanceCard NUMERIC(12,2) NOT NULL DEFAULT 0,
    plafond NUMERIC(12,2),
    typeCard E_CARD NOT NULL,
    ibanBankAccount CHAR(27) REFERENCES smu.BankAccount(ibanBankAccount),

    CONSTRAINT checkCVV CHECK (cvv ~ '^[0-9]{3}$'),
    CONSTRAINT checkValidExpirationDate CHECK ((expirationDate < CURRENT_DATE)),
    CONSTRAINT checkValidIBANCard CHECK (ibanCard ~ '[A-Z]{2}[0-9]{2}[A-Z]{1}[0-9]{5}[0-9]{5}[0-9A-Z]{5}')
);

-- Table Category
CREATE TABLE smu.Category (
    name VARCHAR(255) NOT NULL,
    keyword VARCHAR(50) PRIMARY KEY,

    CONSTRAINT check_keyword CHECK (keyword ~ '^[a-z]{1,50}$')
);

-- Table Portfolio
CREATE TABLE smu.Portfolio (
    idPortfolio INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255),
    taxCode CHAR(16) REFERENCES smu.User(taxCode),
    idFamily INTEGER REFERENCES smu.Family(idFamily),
    keyword VARCHAR(50) REFERENCES smu.Category(keyword)
);

-- Tipo E_TRANSACTION per gestire la differenza tra entrata ed uscita
CREATE TYPE E_TRANSACTION AS ENUM ('expense', 'income');

-- Table Transaction
CREATE TABLE smu.Transaction (
    idTransaction INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    amount NUMERIC(12,2) NOT NULL,
    description VARCHAR(255) NOT NULL,
    dateTime timestamp NOT NULL,
    receiver VARCHAR(255),
    sender VARCHAR(255),
    typeTransaction E_TRANSACTION NOT NULL,
    cardNumber CHAR(16) REFERENCES smu.Card(cardNumber),
    idPortfolio INTEGER REFERENCES smu.Portfolio(idPortfolio),

    CONSTRAINT checkValidDateTime CHECK ((dateTime < CURRENT_TIMESTAMP))
);