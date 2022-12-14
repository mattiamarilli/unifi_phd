DROP SCHEMA IF EXISTS do_schema;
CREATE SCHEMA do_schema;

USE do_schema;
CREATE TABLE Professors (
    Freshman INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Surname VARCHAR(100) NOT NULL,
    Specialization VARCHAR(200) NOT NULL,
    University VARCHAR(200) NOT NULL,
    Email VARCHAR(200) NOT NULL,
    Password VARCHAR(200) NOT NULL,
    PRIMARY KEY (Freshman)
);

CREATE TABLE Courses (
    Code VARCHAR(16) NOT NULL,
    Title VARCHAR(200) NOT NULL,
    Description VARCHAR(2000) NOT NULL,
    CFU INT NOT NULL,
    Year INT NOT NULL,
    ProfessorFreshman INT NOT NULL REFERENCES Professors(Freshman),
    PRIMARY KEY (Code)
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

CREATE TABLE StudyPlans(
        StudentFreshman INT NOT NULL REFERENCES StudentCareers(StudentFreshman),
        CodeCourse VARCHAR(16) NULL REFERENCES Courses(Code),
        State VARCHAR(20) NOT NULL,
        RegistrationDate DATE NOT NULL,
        PRIMARY KEY (StudentFreshman,CodeCourse)
);


CREATE TABLE AppealParticipation(
       StudentFreshman INT NOT NULL REFERENCES StudentCareers(StudentFreshman),
       IdAppeal INT NOT NULL REFERENCES Appeals(Id),
       PRIMARY KEY (StudentFreshman,IdAppeal),
       Vote VARCHAR(20)
)


