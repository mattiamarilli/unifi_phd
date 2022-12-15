USE ta_schema;

-- insert values into Thesis
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State) VALUES('Analysis and comparison between the new file proposals of the different operating systems', 'Thesis description', 'thesisSystemOperative.pdf', 7032459, 'Not approved');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State) VALUES('Design and development of Augmented Reality Apps', 'Thesis description', 'thesisRealityApp.pdf', 5039678, 'Not approved');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State) VALUES('Design and development of Apps for the management of electric vehicles', 'Thesis description', 'thesisAppElectricVehicles.pdf', 2902190, 'Approved');


-- insert values Reviewer
INSERT INTO Reviewer (Freshman, Name, Surname, Password, Email, Description) VALUES('9874328', 'Giuseppe', 'Anastasi', 'Password', 'giuseppe.anastasi@yahoo.com', 'Pervasive computing; Internet of Things; Smart Cities');
INSERT INTO Reviewer (Freshman, Name, Surname, Password, Email, Description) VALUES('3485395', 'Franco', 'Scarselli', 'Password', 'franco.scarselli@unifi.it', 'Machine Learning; Artificial neural networks');
INSERT INTO Reviewer (Freshman, Name, Surname, Password, Email, Description) VALUES('7389203', 'Beatrice', 'Lazzerini', 'Password', 'b.lazzerini@iet.unipi.it', 'Computational Intelligence; Intelligent Decision Making');
INSERT INTO Reviewer (Freshman, Name, Surname, Password, Email, Description) VALUES('5940249', 'Roberto', 'Giorgi', 'Password', 'roberto.giorgi@iid.unisi', 'Computer Architecture; Parallel and Distributed Computing');

-- insert evaluation committee
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (1, 9874328);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (1, 7389203);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (2, 3485395);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (2, 5940249);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (3, 3485395);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (3, 5940249);

-- insert values Review
INSERT INTO Review (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis operative systems', 'Comment', 1, 9874328);
INSERT INTO Review (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis operative systems', 'Comment', 1, 7389203);
INSERT INTO Review (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Reality Apps', 'Comment', 2, 3485395);
INSERT INTO Review (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Reality Apps', 'Comment', 2, 5940249);



