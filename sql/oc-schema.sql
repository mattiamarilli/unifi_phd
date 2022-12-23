DROP SCHEMA IF EXISTS oc_schema;
CREATE SCHEMA oc_schema;

USE oc_schema;

CREATE TABLE Cycles (
             Number INT NOT NULL PRIMARY KEY,
             Year VARCHAR(64) NOT NULL,
             Description VARCHAR(2000) NOT NULL
);

CREATE TABLE Facultymembers (
            Freshman INT NOT NULL PRIMARY KEY,
            Name VARCHAR(64) NOT NULL,
            Surname VARCHAR(64) NOT NULL,
            Email VARCHAR(200) NOT NULL,
            Password VARCHAR(2000) NOT NULL,
            Specialization VARCHAR(64) NOT NULL,
            Institution VARCHAR(64) NOT NULL
);

CREATE TABLE Students(
             Freshman INT NOT NULL PRIMARY KEY,
             Name VARCHAR(64) NOT NULL,
             Surname VARCHAR(64) NOT NULL,
             Email VARCHAR(200) NOT NULL,
             Password VARCHAR(2000) NOT NULL,
             Topics VARCHAR(64) NOT NULL
);

-- find a better name
CREATE TABLE FacultymembersCycle (
              NumberCycle INT NOT NULL REFERENCES Cycles (Number),
              FreshmanFacultymember INT NOT NULL REFERENCES Facultymembers (Freshman) ON DELETE CASCADE,
              PRIMARY KEY (NumberCycle, FreshmanFacultymember)
);
-- find a better name
CREATE TABLE StudentsCycle (
            NumberCycle INT NOT NULL REFERENCES Cycles (Number) ON DELETE CASCADE,
            FreshmanStudent INT NOT NULL REFERENCES Students (Freshman) ON DELETE CASCADE,
            PRIMARY KEY (NumberCycle, FreshmanStudent)
);

CREATE TABLE Advisors(
            FreshmanFacultymember INT NOT NULL REFERENCES Facultymembers (Freshman) ON DELETE CASCADE,
            FreshmanStudent INT NOT NULL REFERENCES Students (Freshman) ON DELETE CASCADE,
            PRIMARY KEY ( FreshmanFacultymember, FreshmanStudent)
);

