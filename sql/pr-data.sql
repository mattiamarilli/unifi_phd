USE pr_schema;


-- insert progress reports
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url1.pdf', 'Load', 2392049);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url2.pdf', 'Load', 3472126);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report', 'url3.pdf', 'Load', 4829483);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report', 'url4.pdf', 'Load', 4728520);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('', '', '', 'Not_load', 3820539);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('', '', '', 'Not_load', 5749305);


-- insert scientists
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (9237583, 'Francesco', 'Pistolesi', 'francesco.pistolesi@unipi.it', 'Password', 'Optimization algorithms based on evolutionary computation');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (9236583, 'Antonio', 'Prete', 'antonio.prete@gmail.com', 'Password', 'Computer Architecture, Embedded Systems and Industrial Applications');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7237583, 'Ludovico', 'Silvestri', 'ludovico.silvestri@polimi.it', 'Password', 'Optical microscopy');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7637583, 'Edmondo', 'Trentin', 'edmondo.trentin@unisi.it', 'Password', 'Neural networks; Graphical models');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7637585, 'Alessio', 'Vecchio', 'alessio.vecchio@unipi.it', 'Password', 'Pervasive and mobile computing');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (5894375, 'Tommaso', 'Agnolucci', 'tommaso.agnolucci@uniro.it', 'Password', 'Improving visual quality of videos and images with deep learning');


-- insert supervisory committees
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (1, 9237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (1, 9236583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (2, 9236583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (2, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (3, 7637583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (3, 9236583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (4, 9237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (4, 7637585);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (5, 7637585);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (5, 5894375);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (6, 5894375);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (6, 9237583);


