USE oc_schema;

INSERT INTO `Cycles` (`Number`, `Year`, `Description`) VALUES ('1', '2000', '\"this is the first edition\"');
INSERT INTO `Cycles` (`Number`, `Year`, `Description`) VALUES ('2', '2001', '\"this is the second edition\"');
INSERT INTO `Cycles` (`Number`, `Year`, `Description`) VALUES ('3', '2002', '\"this is the third edition\"');

INSERT INTO `Students` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Topics`) VALUES ('8283','Pippo','email@test.io','testpassword', 'Rossi', 'SWE');
INSERT INTO `Students` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Topics`) VALUES ('9292','Paperino', 'Bianchi','email@test.io','testpassword', 'AI');
INSERT INTO `Students` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Topics`) VALUES ('8222','Minnie', 'Verdi','email@test.io','testpassword', 'deep learning');
INSERT INTO `Students` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Topics`) VALUES ('2345','Zio', 'Paperone','email@test.io','testpassword', 'make money');

INSERT INTO `Facultymembers` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Specialization`, `Institution`) VALUES ('345','Mario', 'Rossi','email@test.io','testpassword', 'Spec1', 'istit1');
INSERT INTO `Facultymembers` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Specialization`, `Institution`) VALUES ('112','Luca', 'Bianchi','email@test.io','testpassword', 'Spec2', 'istit2');
INSERT INTO `Facultymembers` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Specialization`, `Institution`) VALUES ('321','Giovanni', 'Verdi','email@test.io','testpassword', 'Spec3', 'istit3');
INSERT INTO `Facultymembers` (`Freshman`,`Name`, `Surname`,`Email`,`Password`, `Specialization`, `Institution`) VALUES ('453','Francesco', 'Giallo','email@test.io','testpassword', 'Spec4', 'istit4');

INSERT INTO `FacultymembersCycle` (`NumberCycle`, `FreshmanFacultymember`) VALUES ('1', '345');
INSERT INTO `FacultymembersCycle` (`NumberCycle`, `FreshmanFacultymember`) VALUES ('1', '112');
INSERT INTO `FacultymembersCycle` (`NumberCycle`, `FreshmanFacultymember`) VALUES ('2', '321');
INSERT INTO `FacultymembersCycle` (`NumberCycle`, `FreshmanFacultymember`) VALUES ('3', '453');

INSERT INTO `StudentsCycle` (`NumberCycle`, `FreshmanStudent`) VALUES ('1', '8283');
INSERT INTO `StudentsCycle` (`NumberCycle`, `FreshmanStudent`) VALUES ('1', '9292');
INSERT INTO `StudentsCycle` (`NumberCycle`, `FreshmanStudent`) VALUES ('2', '8222');
INSERT INTO `StudentsCycle` (`NumberCycle`, `FreshmanStudent`) VALUES ('3', '2345');

INSERT INTO `Advisors` (`FreshmanFacultymember`, `FreshmanStudent`) VALUES ('345', '8283');
INSERT INTO `Advisors` (`FreshmanFacultymember`, `FreshmanStudent`) VALUES ('112', '9292');
INSERT INTO `Advisors` (`FreshmanFacultymember`, `FreshmanStudent`) VALUES ('321', '8222');
INSERT INTO `Advisors` (`FreshmanFacultymember`, `FreshmanStudent`) VALUES ('453', '2345');