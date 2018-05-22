INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('eta','eta', TRUE);
INSERT INTO CREDENTIALS(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO ROLE (id,username, role) VALUES (1,'eta', 'ROLE_TRAN');
INSERT INTO ROLE (id,username, role) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO ROLE (id,username, role) VALUES (3,'admin', 'ROLE_STAT');

INSERT INTO  `USER` (id,firstname, lastname,email,channel, is_admin, userCredId) VALUES (1,'Admin','Admin','admin@mongolz.com','MESSAGE',1,'admin');
INSERT INTO `USER` (id,firstname, lastname,email,channel, is_admin,userCredId) VALUES (2,'Enkhtulga','Tseveenkhuu','ts.enkh@wrench.com','MESSAGE',1,'eta');