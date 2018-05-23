INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('eta','eta', TRUE);
INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO ROLE (id,username, role) VALUES (1,'eta', 'ROLE_TRAN');
INSERT INTO ROLE (id,username, role) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO ROLE (id,username, role) VALUES (3,'admin', 'ROLE_STAT');

<<<<<<< HEAD
INSERT INTO  `USERS` (id,firstname, lastname,email,channel, is_admin, userCredId) VALUES (1,'Admin','Admin','admin@mongolz.com','MESSAGE',1,'admin');
INSERT INTO `USERS` (id,firstname, lastname,email,channel, is_admin,userCredId) VALUES (2,'Enkhtulga','Tseveenkhuu','ts.enkh@wrench.com','MESSAGE',1,'eta');
=======
INSERT INTO  `USER` (id,firstname, lastname,email,channel, is_admin, userCredId) VALUES (1,'Admin','Admin','admin@mongolz.com','MESSAGE',1,'admin');
INSERT INTO `USER` (id,firstname, lastname,email,channel, is_admin,userCredId) VALUES (2,'Enkhtulga','Tseveenkhuu','ts.enkh@wrench.com','MESSAGE',1,'eta');

insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id) values (986369, 'Checking', 50000, 1);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id) values (986367, 'Saving', 100000, 1);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id)values (986368, 'Salary', 20000, 1);

insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id) values (986401,'Checking', 50000, 2);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id) values (986402, 'Saving', 100000, 2);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_id)values (986403, 'Salary', 20000, 2);

insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (2000, 'beer', 986369, 986401, STR_TO_DATE('26-04-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (3000, 'tution fee', 986369, 986402, STR_TO_DATE('29-04-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (5, 'cola', 986369, 986403, STR_TO_DATE('01-05-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (5000, 'car', 986369, 986368, STR_TO_DATE('20-05-2018', '%d-%m-%Y'));
>>>>>>> fb94a3d7eacbec413892e17f6f55265375aa6d47
