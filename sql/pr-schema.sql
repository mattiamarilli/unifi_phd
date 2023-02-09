DROP SCHEMA IF EXISTS pr_schema;
CREATE SCHEMA pr_schema;

USE pr_schema;

CREATE TABLE ProgressReports (
  Id INT NOT NULL AUTO_INCREMENT,
  Title VARCHAR(200),
  Description VARCHAR(200),
  UrlDocument VARCHAR(2000),
  State VARCHAR(15) NOT NULL,
  StudentFreshman INT UNIQUE NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE Scientists (
  Freshman INT NOT NULL,
  Name VARCHAR(200) NOT NULL,
  Surname VARCHAR(200) NOT NULL,
  Email VARCHAR(200) NOT NULL,
  Password VARCHAR(200) NOT NULL,
  Description VARCHAR(2000) NOT NULL,
  PRIMARY KEY (Freshman)
);

CREATE TABLE SupervisoryCommittee (
  IdProgressReport INT NOT NULL REFERENCES ProgressReports(Id) ON DELETE CASCADE,
  IdScientist INT NOT NULL REFERENCES Scientists(Freshman) ON DELETE CASCADE,
  PRIMARY KEY (IdProgressReport, IdScientist)
);



