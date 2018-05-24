
INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('deegii','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('deegii', 'ROLE_USER');

INSERT INTO `USERS` (user_id,firstname, lastname,email,channel,userId) VALUES (1,'Admin','Admin','admin@mongolz.com','MSG','admin');
INSERT INTO `USERS` (user_id,firstname, lastname,email,channel,userId) VALUES (2,'Enkhtulga','Tseveenkhuu','guest@mongolz.com','MSG','guest');
INSERT INTO `USERS` (user_id,firstname, lastname,email,channel,userId) VALUES (3,'Munkhdelger','Buyandalai','deegii212@gmail.com','EMAIL','deegii');


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

