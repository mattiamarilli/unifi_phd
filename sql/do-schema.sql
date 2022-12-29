DROP SCHEMA IF EXISTS do_schema;
CREATE SCHEMA do_schema;

USE do_schema;

CREATE TABLE Courses (
    Code VARCHAR(16) NOT NULL,
    Title VARCHAR(200) NOT NULL,
    Description VARCHAR(2000) NOT NULL,
    CFU INT NOT NULL,
    Year INT NOT NULL,
    PRIMARY KEY (Code)
);

CREATE TABLE Professors (
  Freshman INT NOT NULL,
  Name VARCHAR(100) NOT NULL,
  Surname VARCHAR(100) NOT NULL,
  Specialization VARCHAR(200) NOT NULL,
  University VARCHAR(200) NOT NULL,
  Email VARCHAR(200) NOT NULL,
  Password VARCHAR(200) NOT NULL,
  CodeCourse VARCHAR(16) NOT NULL REFERENCES Courses(Code),
  PRIMARY KEY (Freshman)
);

CREATE TABLE Lessons (
    Id INT NOT NULL AUTO_INCREMENT,
    Date DATE NOT NULL,
    StartTime TIME(2) NOT NULL,
    EndTime TIME NOT NULL,
    Room INT,
    UniversityComplex VARCHAR(200),
    University VARCHAR(200),
    Mode VARCHAR(7) NOT NULL,
    CodeCourse VARCHAR(16) NOT NULL REFERENCES Courses(Code),
    PRIMARY KEY (Id)
);

CREATE TABLE Appeals (
    Id INT NOT NULL AUTO_INCREMENT,
    Date DATE NOT NULL,
    StartTime TIME NOT NULL,
    Room INT,
    UniversityComplex VARCHAR(200),
    University VARCHAR(200),
    Note VARCHAR(200),
    Mode VARCHAR(7) NOT NULL,
    CodeCourse VARCHAR(16) NOT NULL REFERENCES Courses(Code),
    PRIMARY KEY (Id)
);

CREATE TABLE StudentCareers (
    StudentFreshman INT NOT NULL,
    PRIMARY KEY (StudentFreshman)
);

CREATE TABLE CourseRegistrations (
    StudentFreshman INT NOT NULL REFERENCES StudentCareers(StudentFreshman),
    CodeCourse VARCHAR(16) NOT NULL REFERENCES Courses(Code),
    DateRegistration DATE NOT NULL,
    State VARCHAR(10) NOT NULL,
    PRIMARY KEY (StudentFreshman, CodeCourse)
);

CREATE TABLE ExamSupport (
    StudentFreshman INT NOT NULL REFERENCES StudentCareers(StudentFreshman),
    IdAppeal INT NOT NULL REFERENCES Appeals(Id),
    Vote VARCHAR(20) NOT NULL,
    Note VARCHAR(20),
    Presence VARCHAR(8) NOT NULL,
    PRIMARY KEY (StudentFreshman, IdAppeal)
);




