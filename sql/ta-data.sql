USE ta_schema;

-- insert values into Thesis
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('Analysis and comparison between the new file proposals of the different operating systems', 'Thesis description', 'thesisSystemOperative.pdf', 0102829, 'Not_approved', 'Load');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('Design and development of Augmented Reality Apps', 'Thesis description', 'thesisRealityApp.pdf', 7028492, 'Not_approved', 'Not_load');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('Design and development of Apps for the management of electric vehicles', 'Thesis description', 'thesisAppElectricVehicles.pdf', 3820392, 'Approved', 'Load');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('', '', '', 3920391, 'Not_approved', 'Load');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('Deep Learning Methods for Document Image Understanding', 'Thesis description', 'thesisDeepLearning.pdf', 3923920, 'Approved', 'Load');
INSERT INTO Thesis (Title, Description, UrlDocument, StudentFreshman, State, Loaded) VALUES('Network Monitoring and Management in the Future Internet', 'Thesis description', 'thesisNetworkMonitoring.pdf', 4728103, 'Approved', 'Load');


-- insert values Reviewer
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(9874328, 'Giuseppe', 'Anastasi', 'Password', 'giuseppe.anastasi@yahoo.com', 'Pervasive computing; Internet of Things; Smart Cities');
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(3485395, 'Franco', 'Scarselli', 'Password', 'franco.scarselli@unifi.it', 'Machine Learning; Artificial neural networks');
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(7389203, 'Beatrice', 'Lazzerini', 'Password', 'b.lazzerini@iet.unipi.it', 'Computational Intelligence; Intelligent Decision Making');
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(5940249, 'Roberto', 'Giorgi', 'Password', 'roberto.giorgi@iid.unisi.it', 'Computer Architecture; Parallel and Distributed Computing');
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(8420391, 'Pietro', 'Pala', 'Password', 'pietro.pala@unifi.it', 'Computer Vision; Multimedia Systems');
INSERT INTO Reviewers (Freshman, Name, Surname, Password, Email, Description) VALUES(3294503, 'Andrea', 'Passarella', 'Password', 'andrea.passarella@unifi.it', 'Mobile networks; Social networking');


-- insert evaluation committee
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (1, 9874328);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (1, 7389203);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (2, 3485395);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (2, 5940249);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (3, 3485395);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (3, 5940249);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (4, 8420391);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (4, 3294503);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (5, 3485395);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (5, 3294503);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (6, 9874328);
INSERT INTO EvaluationCommittee (IdThesis, IdReviewer) VALUES (6, 3485395);




-- insert values Review
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis operative systems', 'Comment', 1, 9874328);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis operative systems', 'Comment', 1, 7389203);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Reality Apps', 'Comment', 2, 3485395);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Reality Apps', 'Comment', 2, 5940249);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Apps for the management of electric vehicles', 'Comment', 3, 3485395);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Apps for the management of electric vehicles', 'Comment', 3, 5940249);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Deep Learning Methods', 'Comment', 5, 3485395);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Deep Learning Methods', 'Comment', 5, 3294503);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Network Monitoring and Management in the Future Internet', 'Comment', 6, 9874328);
INSERT INTO Reviews (Title, Comment, IdThesis, IdReviewer) VALUES ('Correction Thesis Network Monitoring and Management in the Future Internet', 'Comment', 6, 3485395);


