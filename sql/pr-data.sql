USE pr_schema;


-- insert progress reports
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url1.pdf', 'Load', 7328102);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url2.pdf', 'Load', 9302912);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url3.pdf', 'Load', 3920391);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report', 'url4.pdf', 'Load', 3920391);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('', '', '', 'Not_load', 7328102);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('', '', '', 'Not_load', 9302912);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url4.pdf', 'Load', 3923920);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report (update)', 'url3.pdf', 'Load', 3923920);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url4.pdf', 'Load', 3820392);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report (update)', 'url3.pdf', 'Load', 3820392);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end first year', 'Description progress report', 'url4.pdf', 'Load', 4728103);
INSERT INTO ProgressReports (Title, Description, UrlDocument, State, StudentFreshman) VALUES ('Progress Report end second year', 'Description progress report (update)', 'url3.pdf', 'Load', 4728103);


-- insert scientists
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (9237583, 'Francesco', 'Pistolesi', 'francesco.pistolesi@unipi.it', 'Password', 'Optimization algorithms based on evolutionary computation');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (9236583, 'Antonio', 'Prete', 'antonio.prete@gmail.com', 'Password', 'Computer Architecture, Embedded Systems and Industrial Applications');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7237583, 'Ludovico', 'Silvestri', 'ludovico.silvestri@polimi.it', 'Password', 'Optical microscopy');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7637583, 'Edmondo', 'Trentin', 'edmondo.trentin@unisi.it', 'Password', 'Neural networks; Graphical models');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (7637585, 'Alessio', 'Vecchio', 'alessio.vecchio@unipi.it', 'Password', 'Pervasive and mobile computing');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (5894375, 'Tommaso', 'Agnolucci', 'tommaso.agnolucci@uniro.it', 'Password', 'Improving visual quality of videos and images with deep learning');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (4029304, 'Guido', 'Simionato', 'guido.simionato@unisi.it', 'Password', 'Affective Computing and eXplainable Artificial Intelligence');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (5749284, 'Cinzia', 'Talamonti', 'cinzia.talamonti@unito.it', 'Password', 'Medical Physics');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (0049281, 'Francesco', 'Marcelloni', 'francesco.marcelloni@unipi.it', 'Password', 'Evolutionary algorithms; fuzzy systems; pattern recognition');
INSERT INTO Scientists (Freshman, Name, Surname, Email, Password, Description) VALUES (0802274, 'Leonardo', 'Bacciottini', 'leonardo.bacciottini@polimi.it', 'Password', 'Quantum Internet protocols and technologies.');



-- insert supervisory committees
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (1, 9237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (1, 4029304);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (2, 9236583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (2, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (3, 7637583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (3, 0049281);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (4, 4029304);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (4, 5749284);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (5, 0802274);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (5, 0049281);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (6, 5894375);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (6, 9237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (7, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (7, 5894375);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (8, 9237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (8, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (9, 4029304);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (9, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (10, 7237583);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (10, 5749284);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (11, 0049281);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (11, 0802274);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (12, 0049281);
INSERT INTO SupervisoryCommittee (IdProgressReport, IdScientist) VALUES (12, 7637583);


