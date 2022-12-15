DROP SCHEMA IF EXISTS ta_schema;
CREATE SCHEMA ta_schema;

USE ta_schema;

CREATE TABLE Thesis (
  Id INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(120) NOT NULL,
  Description VARCHAR(2000) NOT NULL,
  UrlDocument VARCHAR(300) NOT NULL,
  StudentFreshman INT NOT NULL,
  State VARCHAR(15),
  PRIMARY KEY (Id)
);

CREATE TABLE Review (
  Id INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(120) NOT NULL,
  Comment VARCHAR(2000) NOT NULL,
  IdThesis INT NOT NULL REFERENCES Thesis(Id),
  PRIMARY KEY (Id)
);

-- add password
CREATE TABLE Reviewer (
  Freshman INT NOT NULL,
  Email VARCHAR(200) NOT NULL,
  Name VARCHAR(100) NOT NULL,
  Surname VARCHAR(100) NOT NULL,
  Description VARCHAR(2000) NOT NULL,
  PRIMARY KEY (Freshman)
);

CREATE TABLE EvaluationCommittee (
  IdThesis INT NOT NULL REFERENCES Thesis(Id),
  IdReviewer INT NOT NULL REFERENCES Reviewer(Freshman)
);

