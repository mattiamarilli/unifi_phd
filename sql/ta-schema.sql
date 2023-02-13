DROP SCHEMA IF EXISTS ta_schema;
CREATE SCHEMA ta_schema;

USE ta_schema;

CREATE TABLE Thesis (
  Id INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(120),
  Description VARCHAR(2000),
  UrlDocument VARCHAR(300),
  StudentFreshman INT NOT NULL,
  State VARCHAR(15) NOT NULL,
  Loaded VARCHAR(15) NOT NULL,
  PRIMARY KEY (Id)
);

-- add password (insert cryptographic)
CREATE TABLE Reviewers (
  Freshman INT NOT NULL,
  Name VARCHAR(100) NOT NULL,
  Surname VARCHAR(100) NOT NULL,
  Password VARCHAR(2000) NOT NULL,
  Email VARCHAR(200) NOT NULL,
  Description VARCHAR(2000) NOT NULL,
  PRIMARY KEY (Freshman)
);

CREATE TABLE EvaluationCommittee (
  IdThesis INT NOT NULL REFERENCES Thesis(Id) ON DELETE CASCADE,
  IdReviewer INT NOT NULL REFERENCES Reviewers(Freshman) ON DELETE CASCADE,
  PRIMARY KEY (IdThesis, IdReviewer)
);

CREATE TABLE Reviews (
    Id INT NOT NULL AUTO_INCREMENT,
    Title VARCHAR(120) NOT NULL,
    Comment VARCHAR(2000) NOT NULL,
    IdThesis INT NOT NULL REFERENCES Thesis(Id) ON DELETE CASCADE,
    IdReviewer INT NOT NULL REFERENCES Reviewers(Freshman) ON DELETE CASCADE,
    PRIMARY KEY (Id)
);
