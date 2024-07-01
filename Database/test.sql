-- Questo file riporta le varie insert per testare il database

-- Family
INSERT INTO smu.Family(name) VALUES ('Family 1');

-- User
INSERT INTO smu.User(name, surname, username, password, email, taxCode, birthDate, idFamily) VALUES ('Mario', 'Rossi', 'user1', 'password1', 'mariorossi7@example.com', 'RSSMRA85M01H501Z', '1985-03-01', 1);
INSERT INTO smu.User(name, surname, username, password, email, taxCode, birthDate, idFamily) VALUES ('Laura', 'Bianchi', 'user2', 'password2', 'laurabianchi7@example.com', 'BNCLRA91C12F205X', '1991-03-12', 1);
INSERT INTO smu.User(name, surname, username, password, email, taxCode, birthDate) VALUES ('Luigi', 'Verdi', 'user3', 'password3', 'luigiverdi3@example.com', 'VRDLGI74P22H223W', '1974-09-22');

-- PaymentMethod

-- Conto bancario di Mario Rossi
INSERT INTO smu.PaymentMethod(balance, iban, typeMethod, taxCode) VALUES (2000, 'IT12A1234567890123456789012', 'bankAccount', 'RSSMRA85M01H501Z');
-- Conto bancario di Laura Bianchi
INSERT INTO smu.PaymentMethod(balance, iban, typeMethod, taxCode) VALUES (2000, 'IT12A1234567890123456789013', 'bankAccount', 'BNCLRA91C12F205X');
-- Denaro contante di Luigi Verdi
INSERT INTO smu.PaymentMethod(balance, iban, typeMethod, taxCode) VALUES (1000, 'cash', 'VRDLGI74P22H223W');

-- Card

-- Carta di debito senza IBAN associata al conto di Mario Rossi
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, idPaymentMethod) VALUES ('1234567890123456', '123', '2028-03-01', 'debitCard', 1);
-- Carta di credito con IBAN associata al conto di Laura Bianchi
INSERT INTO smu.Card(cardNumber, cvv, expirationDate, ibanCard, typeCard, idPaymentMethod) VALUES ('1234567890123457', '123', '2028-03-01', 'IT12A1234567890123456789014','creditCard', 2);

-- Portfolio

-- Portfolio di Mario Rossi
INSERT INTO smu.Portfolio(name, description, idUser) VALUES ('Portfolio 1', 'Portafoglio di Mario Rossi', 1);
-- Portfolio di Luigi Verdi
INSERT INTO smu.Portfolio(name, description, idUser) VALUES ('Portfolio 2', 'Portafoglio di Luigi Verdi', 3);

-- TODO: Aggiungere altre classi
