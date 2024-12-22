INSERT INTO dbuser (id ,username, password, role) VALUES
(1,'dbadmin', '$2y$10$kp1V7UYDEWn17WSK16UcmOnFd1mPFVF6UkLrOOCGtf24HOYt8p1iC', 'ADMIN');

-- user: dbadmin
-- password: admin


INSERT INTO dbuser (id ,username, password, role) VALUES
(2,'dbuser', '$2a$10$Aaq2bmAmcJX37s0zESONreFM2097VLI7V5b9arMIq.L2UsbNzBTaK', 'USER');

-- user: dbuser
-- password: user



INSERT INTO produit (id , description, montant, nom) VALUES
('845fc960-74c7-4cb0-8212-5bfd6dcc6f01' , 'ma description de tomate' , 500 , 'tomate' ) ;

INSERT INTO produit (id , description, montant, nom) VALUES
('845fc960-74c7-4cb0-8212-5bfd6dcc6f02' , 'ma description de orange' , 200 , 'orange' ) ;



INSERT INTO SOUSCRIPTION(id, date_soumission , debut_couverture, fin_couverture, montant, produit_id , user_id) VALUES
('8484e456-ff12-4031-a85f-f88f262f6344', '2024-12-22',  '2024-12-22', '2025-12-21',500 , '845fc960-74c7-4cb0-8212-5bfd6dcc6f01', 1);

INSERT INTO SOUSCRIPTION(id, date_soumission , debut_couverture, fin_couverture, montant, produit_id , user_id) VALUES
('8484e456-ff12-4031-a85f-f88f262f6342', '2024-12-12',  '2024-12-22', '2025-12-21',500 , '845fc960-74c7-4cb0-8212-5bfd6dcc6f02', 1);