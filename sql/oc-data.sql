USE oc_schema;

INSERT INTO Cycles (Number, Year, Description) VALUES ('1', 2000, '\"this is the first edition\"');
INSERT INTO Cycles (Number, Year, Description) VALUES ('2', 2001, '\"this is the second edition\"');
INSERT INTO Cycles (Number, Year, Description) VALUES ('3', 2002, '\"this is the third edition\"');

INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (345,'Mario', 'Rossi','email@test.io','testpassword', 'Spec1', 'istit1', '1');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (112,'Luca', 'Bianchi','email@test.io','testpassword', 'Spec2', 'istit2', '1');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (321,'Giovanni', 'Verdi','email@test.io','testpassword', 'Spec3', 'istit3', '2');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (453,'Francesco', 'Giallo','email@test.io','testpassword', 'Spec4', 'istit4', '3');

INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (8283,'Pippo','email@test.io','testpassword', 'Rossi', 'SWE', 1, 2, 345);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (9292,'Paperino', 'Bianchi','email@test.io','testpassword', 'AI', 2, 3);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (8222,'Minnie', 'Verdi','email@test.io','testpassword', 'deep learning', 3, 4);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (2345,'Zio', 'Paperone','email@test.io','testpassword', 'make money', 1, 4);