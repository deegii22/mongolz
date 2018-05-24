INSERT INTO Authentication(user,password,enabled) VALUES ('eta','eta', TRUE);
INSERT INTO Authentication(user,password,enabled) VALUES ('admin','admin', TRUE);
INSERT INTO Authentication(user,password,enabled) VALUES ('deegii','deegii', TRUE);

INSERT INTO AUTHORITY (id,username, authority) VALUES (1,'eta', 'ROLE_TRAN');
INSERT INTO AUTHORITY (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITY (id,username, authority) VALUES (3,'admin', 'ROLE_STAT');

INSERT INTO credential_authority (credential_id,authority_id) VALUES ('eta',1);
INSERT INTO credential_authority (credential_id,authority_id) VALUES ('admin',2);
INSERT INTO credential_authority (credential_id,authority_id) VALUES ('admin',3);

INSERT INTO `USERS` (user_id,firstname, lastname,email,channel, is_admin, userId) VALUES (1,'Admin','Admin','admin@mongolz.com','EMAIL',1,'admin');
INSERT INTO `USERS` (user_id,firstname, lastname,email,channel, is_admin,userId) VALUES (2,'Enkhtulga','Tseveenkhuu','ts.enkh@wrench.com','EMAIL',1,'eta');
INSERT INTO `USERS` (user_id,firstname, lastname,email,channel, is_admin,userId) VALUES (3,'Munkhdelger','Buyandalai','deegii212@gmail.com','EMAIL',1,'deegii');

insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id) values (986369, 'Checking', 50000, 1);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id) values (986367, 'Saving', 100000, 1);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id)values (986368, 'Salary', 20000, 1);

insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id) values (986401,'Checking', 50000, 2);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id) values (986402, 'Saving', 100000, 2);
insert into ACCOUNT (ACCOUNT_NO, AccountName, balance, user_user_id)values (986403, 'Salary', 20000, 2);

insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (2000, 'beer', 986369, 986401, STR_TO_DATE('26-04-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (3000, 'tution fee', 986369, 986402, STR_TO_DATE('29-04-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (5, 'cola', 986369, 986403, STR_TO_DATE('01-05-2018', '%d-%m-%Y'));
insert into TRANSACTION (amount, description, fromAccount, toAccount, created)
values (5000, 'car', 986369, 986368, STR_TO_DATE('20-05-2018', '%d-%m-%Y'));

