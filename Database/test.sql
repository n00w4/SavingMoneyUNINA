-- Questo file riporta le varie insert per popolare e testare il database

-- Family
INSERT INTO smu.Family(familyName) VALUES ('Famiglia Rossi');

-- User
INSERT INTO smu.User(firstName, secondName, username, password, email, taxCode, birthDate, idFamily) VALUES ('Mario', 'Rossi', 'user1', 'Test@123', 'mariorossi7@example.com', 'RSSMRA85M01H501Z', '1985-03-01', 1);
INSERT INTO smu.User(firstName, secondName, username, password, email, taxCode, birthDate, idFamily) VALUES ('Laura', 'Bianchi', 'user2', 'Test@123', 'laurabianchi7@example.com', 'BNCLRA91C12F205X', '1991-03-12', 1);
INSERT INTO smu.User(firstName, secondName, username, password, email, taxCode, birthDate) VALUES ('Luigi', 'Verdi', 'user3', 'Test@123', 'luigiverdi3@example.com', 'VRDLGI74P22H223W', '1974-09-22');

-- BankAccount

-- Conto bancario di Mario Rossi
INSERT INTO smu.BankAccount(bankName, balance, ibanBankAccount, taxCode) VALUES ('Banca 1', 3000, 'IT12A1234567890123456789012', 'RSSMRA85M01H501Z');
-- Conto bancario di Laura Bianchi
INSERT INTO smu.BankAccount(bankName, balance, ibanBankAccount, taxCode) VALUES ('Banca 1', 2000, 'IT12A1234567890123456789013', 'BNCLRA91C12F205X');
-- Conto bancario di Luigi Verdi
INSERT INTO smu.BankAccount(bankName, balance, ibanBankAccount, taxCode) VALUES ('Banca 2', 3200, 'IT12A1234567890123456789014', 'VRDLGI74P22H223W');

-- Card

-- Carta di debito senza IBAN associata al conto di Mario Rossi
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, ibanBankAccount) VALUES ('1234567890123456', '123', '2029-03-01', 'IT12A1234567890123456789011', 'debitCard', 'IT12A1234567890123456789012');
-- Carta di credito con IBAN associata al conto di Laura Bianchi
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, ibanBankAccount) VALUES ('1234567890123457', '123', '2028-03-02', 'IT12A1234567890123456789013','creditCard', 'IT12A1234567890123456789013');
-- Carta di credito con IBAN associata al conto di Luigi Verdi
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, ibanBankAccount) VALUES ('1234567890123458', '123', '2030-05-01', 'IT12A1234567890123456789014','creditCard', 'IT12A1234567890123456789014');

-- Category
INSERT INTO smu.Category(name, keyword) VALUES ('Spesa', 'spesa');
INSERT INTO smu.Category(name, keyword) VALUES ('Stipendio', 'stipendio');
INSERT INTO smu.Category(name, keyword) VALUES ('Utenza energia', 'utenze');
INSERT INTO smu.Category(name, keyword) VALUES ('Portfolio generale', 'generale');
INSERT INTO smu.Category(name, keyword) VALUES ('Portfolio familiare generale', 'famiglia');

-- Portfolio

-- Portfolio di Luigi Verdi
INSERT INTO smu.Portfolio(name, description, taxCode, idFamily, keyword) VALUES ('Portfolio personale', 'Portafoglio generale di Luigi Verdi', 'VRDLGI74P22H223W', NULL, 'generale');
-- Portafoglio Famiglia Rossi
INSERT INTO smu.Portfolio(name, description, taxCode, idFamily, keyword) VALUES ('Portfolio Rossi', 'Bollette e spese utenze Famiglia Rossi', NULL, 1, 'utenze');

-- Transaction

-- Transazione in uscita Famiglia Rossi
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, sender, typeTransaction, cardNumber, idPortfolio) VALUES (1000, 'Gas', '2022-01-01', 'Società Energia', NULL, 'expense', '1234567890123456', 2);
-- Transazione in entrata per Luigi Verdi
INSERT INTO smu.Transaction(amount, description, dateTime, receiver, sender, typeTransaction, cardNumber, idPortfolio) VALUES (2000, 'Stipendio mensile', '2023-01-01', NULL, 'Società Energia', 'income', '1234567890123458', 1);

