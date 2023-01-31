DROP SCHEMA IF EXISTS oc_schema;
CREATE SCHEMA oc_schema;

USE oc_schema;

CREATE TABLE Cycles (
             Number INT NOT NULL PRIMARY KEY,
             Year VARCHAR(64) NOT NULL,
             Description VARCHAR(2000) NOT NULL
);

CREATE TABLE FacultyMembers (
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
             Topics VARCHAR(64) NOT NULL,
             Cycle INT NOT NULL REFERENCES Cycles(Number),
             Advisor INT REFERENCES FacultyMembers(Freshman)
);



