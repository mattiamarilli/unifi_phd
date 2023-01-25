USE do_schema;


-- insert courses
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B032592', 'Cellular Neural Networks (CNN): Theory and Recent Applications in Engineering', 'Description course', 3, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B037592', 'Genetic Algorithms', 'Description course', 2, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B056592', 'Third Generation Genomics', 'Description course', 4, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B087592', 'Optimization Algorithms in Machine Learning', 'Description course', 2, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B087292', 'From Quantum Networking to the Quantum Internet', 'Description course', 5, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B002352', 'Theoretical fundamentals of Neural Networks', 'Description course', 1, 2022);



-- insert professors
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1029371, 'Francesco', 'Chiti', 'Statistical signal processing; Remote sensing', 'University of Florence', 'francesco.chiti@unifi.it', 'Password', 'B032592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1129371, 'Giorgio', 'Battistelli', 'Control Systems; Sensor networks', 'University of Florence', 'giorgio.battistelli@unifi.it', 'Password', 'B037592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1229371, 'Laura', 'Carnevali', 'Quantitative evaluation; Formal methods; Real-time systems', 'University of Florence', 'laura.carnevali@unifi.it', 'Password', 'B056592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1329371, 'Angelo', 'Freni', 'Microwave and millimeter wave systems; Numerical techniques for antenna analysis', 'University of Florence', 'angelo.freni@unifi.it', 'Password', 'B087592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1429371, 'Alessandro', 'Piva', 'Multimedia security; Image processing', 'University of Florence', 'alessandro.piva@unifi.it', 'Password', 'B087592');


-- insert lessons
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-12-28', '8:30', '10:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B032592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-01-04', '9:30', '11:30', 005, 'Santa Marta', 'University of Florence', 'Presence', 'B032592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-09-30', '14:00', '16:00', null, '', '', 'Online', 'B037592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-11-26', '8:40', '11:40', null, '', '', 'Online', 'B037592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-12-02', '17:15', '19:15', 014, 'Santa Marta', 'University of Florence', 'Presence', 'B037592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-04', '8:30', '9:30', null, '', '', 'Online', 'B056592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-11', '8:30', '9:30', null, '', '', 'Online', 'B056592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-18', '10:00', '11:00', null, '', '', 'Online', 'B056592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-01', '14:30', '17:30', 164, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-08', '14:30', '17:30', 164, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-14', '15:15', '17:15', 014, 'Santa Marta', 'University of Florence', 'Presence', 'B087292');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-03-21', '15:15', '17:15', 132, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087292');


-- insert appeals
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-01-30', '8:30', 011, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B032592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-02-15', '8:30', 011, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B032592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-01-15', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B037592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-02-08', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B037592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-06-21', '8:30', null, '', '', 'Oral', 'Online', 'B056592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-07-13', '8:30', null, '', '', 'Oral', 'Online', 'B056592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-06-12', '14:00', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B087592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-07-09', '14:00', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B087592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-06-11', '15:00', 165, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B087292');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-07-15', '8:40', 003, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'B087292');


-- insert student careers
INSERT INTO StudentCareers (StudentFreshman) VALUES (4893753);
INSERT INTO StudentCareers (StudentFreshman) VALUES (5738035);
INSERT INTO StudentCareers (StudentFreshman) VALUES (2059357);
INSERT INTO StudentCareers (StudentFreshman) VALUES (1093573);
INSERT INTO StudentCareers (StudentFreshman) VALUES (3918313);
INSERT INTO StudentCareers (StudentFreshman) VALUES (2492842);


-- insert study plans
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4893753, 'B032592', 'Registered', '2022-09-14');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4893753, 'B037592', 'Registered', '2022-09-14');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4893753, 'B056592', 'Registered', '2022-12-10');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (5738035, 'B032592', 'Registered', '2022-09-10');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (5738035, 'B087592', 'Attended', '2022-12-08');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (5738035, 'B087292', 'Accredited', '2022-12-08');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (2059357, 'B037592', 'Accredited', '2022-09-09');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (2059357, 'B087592', 'Accredited', '2022-12-22');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (1093573, 'B032592', 'Attended', '2022-09-15');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (1093573, 'B056592', 'Attended', '2022-11-29');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (1093573, 'B087292', 'Attended', '2023-01-02');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3918313, 'B087292', 'Registered', '2022-12-01');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3918313, 'B087592', 'Attended', '2022-12-30');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (2492842, 'B037592', 'Attended', '2022-08-30');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (2492842, 'B087292', 'Accredited', '2022-12-05');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (2492842, 'B087592', 'Accredited', '2022-11-20');


-- insert appeal participation
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (5738035, 7, '17');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (5738035, 9, '25');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2059357, 3, '15');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2059357, 4, '27');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2059357, 8, '30L');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (1093573, 1, 'Retired');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (1093573, 2, null);

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3918313, 7, '15');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2492842, 3, 'Retired');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2492842, 4, null);
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2492842, 9, '28');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2492842, 7, '16');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (2492842, 8, '23');









