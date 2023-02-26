USE do_schema;


-- insert courses
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B032592', 'Cellular Neural Networks (CNN): Theory and Recent Applications in Engineering', 'Description course', 3, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B037592', 'Genetic Algorithms', 'Description course', 2, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B056592', 'Third Generation Genomics', 'Description course', 4, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B087592', 'Optimization Algorithms in Machine Learning', 'Description course', 2, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B087292', 'From Quantum Networking to the Quantum Internet', 'Description course', 5, 2022);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B002352', 'Theoretical fundamentals of Neural Networks', 'Description course', 1, 2022);

INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B002849', 'Computer Vision applied to assisted and self driving', 'Description course', 3, 2019);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('C003830', 'Multiobjective Mixed Integer Programming', 'Description course', 6, 2019);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('C043352', 'Deep Learning with Memory', 'Description course', 6, 2020);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B020392', 'Quantum Key Distribution', 'Description course', 3, 2020);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('A009381', 'Orchestration of Software-Defined Infrastructures for Edge Computing Applications ', 'Description course', 2, 2021);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('C583013', 'Intelligent cybersecurity', 'Description course', 4, 2021);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B043910', '3D Computer Vision', 'Description course', 3, 2023);
INSERT INTO Courses (Code, Title, Description, CFU, Year) VALUES ('B184721', 'Stochastic Model Checking', 'Description course', 6, 2023);




-- insert professors
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1029371, 'Francesco', 'Chiti', 'Statistical signal processing; Remote sensing', 'University of Florence', 'francesco.chiti@unifi.it', 'Password', 'B032592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1129371, 'Giorgio', 'Battistelli', 'Control Systems; Sensor networks', 'University of Florence', 'giorgio.battistelli@unifi.it', 'Password', 'B037592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1229371, 'Laura', 'Carnevali', 'Quantitative evaluation; Formal methods; Real-time systems', 'University of Florence', 'laura.carnevali@unifi.it', 'Password', 'B056592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1329371, 'Angelo', 'Freni', 'Microwave and millimeter wave systems; Numerical techniques for antenna analysis', 'University of Florence', 'angelo.freni@unifi.it', 'Password', 'B087592');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1429371, 'Alessandro', 'Piva', 'Multimedia security; Image processing', 'University of Florence', 'alessandro.piva@unifi.it', 'Password', 'B087592');

INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (1293818, 'Mieke', 'Massink', 'My current main research interests are in formal specification and verification of semantic models and the design of related tools for concurrent systems', 'University of Pisa', 'mieke.massik@unipi.it', 'Password', 'B002849');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9033829, 'Marco', 'Procaccini', 'The AXIOM Project: IoT on Heterogeneous Embedded Platforms', 'University of Florence', 'marco.procaccini@unifi.it', 'Password', 'C003830');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9937292, 'Federico', 'Becattini', 'Small Satellites Communications and Networks', 'University of Florence', 'federico.becattini@unifi.it', 'Password', 'C043352');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9836289, 'Marianna', 'De Santis', '', 'University of Rome', 'marianna.desantis@uniro.it', 'Password', 'B020392');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9892738, 'David', 'Angeli', 'Image processing', 'University of Siena', 'david.angeli@unipi.it', 'Password', 'A009381');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9764829, 'Leonardo', 'Montecchi', 'Model-Driven Engineering and its Application to Dependability Analysis', 'University of Campinas', 'leonardo.montecchi@gmail.com', 'Password', 'C583013');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9737482, 'Graziano', 'Chesi', 'Recent trends in memristors theory and applications', 'University of Pisa', 'graziano.chesi@unipi.it', 'Password', 'B043910');
INSERT INTO Professors (Freshman, Name, Surname, Specialization, University, Email, Password, CodeCourse) VALUES (9876583, 'Stefano', 'Maddio', 'Indoor Wireless Positioning', 'University of Siena', 'stefano.maddio@unisi.it', 'Password', 'B184721');


-- insert lessons
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-12-28', '8:30', '10:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B032592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-01-04', '9:30', '11:30', 005, 'Santa Marta', 'University of Florence', 'Presence', 'B032592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-09-30', '14:00', '16:00', null, null, null, 'Online', 'B037592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-11-26', '8:40', '11:40', null, null, null, 'Online', 'B037592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-12-02', '17:15', '19:15', 014, 'Santa Marta', 'University of Florence', 'Presence', 'B037592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-04', '8:30', '9:30', null, null, null, 'Online', 'B056592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-11', '8:30', '9:30', null, null, null, 'Online', 'B056592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-18', '10:00', '11:00', null, null, null, 'Online', 'B056592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-01', '14:30', '17:30', 164, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087592');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-08', '14:30', '17:30', 164, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087592');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-14', '15:15', '17:15', 014, 'Santa Marta', 'University of Florence', 'Presence', 'B087292');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2022-03-21', '15:15', '17:15', 132, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B087292');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2019-11-28', '8:30', '10:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B002849');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2019-12-04', '9:30', '11:30', 005, 'Santa Marta', 'University of Florence', 'Presence', 'B002849');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2019-10-08', '11:30', '13:30', 121, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'C003830');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2019-12-04', '14:30', '17:30', 125, 'Santa Marta', 'University of Florence', 'Presence', 'C003830');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2020-03-08', '08:30', '11:30', 221, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'C043352');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2020-03-04', '16:30', '19:00', 225, 'Santa Marta', 'University of Florence', 'Presence', 'C043352');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2020-04-18', '15:30', '18:00', 027, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B020392');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2020-04-24', '14:00', '16:30', 018, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B020392');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-03-18', '08:30', '11:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'A009381');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-03-14', '10:30', '12:30', 003, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'A009381');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-11-18', '18:30', '19:30', 001, 'Santa Marta', 'University of Florence', 'Presence', 'C583013');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-12-14', '11:30', '12:30', 003, 'Santa Marta', 'University of Florence', 'Presence', 'C583013');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-10-18', '08:30', '11:30', 111, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B043910');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-11-14', '14:00', '16:00', 013, 'Santa Marta', 'University of Florence', 'Presence', 'B043910');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-03-18', '08:30', '11:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'A009381');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2021-03-14', '10:30', '12:30', 003, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'A009381');

INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-04-08', '17:30', '19:30', 101, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B184721');
INSERT INTO Lessons (Date, StartTime, EndTime, Room, UniversityComplex, University, Mode, CodeCourse) VALUES ('2023-04-14', '10:30', '12:30', 073, 'Centro Didattico Morgagni', 'University of Florence', 'Presence', 'B184721');



-- insert appeals
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-01-30', '8:30', 011, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B032592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-02-15', '8:30', 011, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B032592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-01-15', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B037592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-02-08', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B037592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-06-21', '8:30', null, '', '', 'Oral', 'Online', 'B056592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-07-13', '8:30', null, '', '', 'Oral', 'Online', 'B056592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-06-12', '14:00', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B087592');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-07-09', '14:00', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B087592');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-06-11', '15:00', 165, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B087292');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-07-15', '8:40', 003, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'B087292');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-01-07', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B002849');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-02-13', '10:00', 122, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B002849');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-01-05', '14:00', 012, 'Santa Marta', 'University of Florence', 'Written', 'Presence', 'C003830');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-02-01', '08:30', 031, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'C003830');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-06-21', '11:00', 125, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'C043352');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-07-05', '9:40', 023, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'C043352');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-06-18', '8:00', 025, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'B020392');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2020-06-21', '14:40', 013, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'B020392');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2021-06-06', '10:00', 125, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'A009381');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2021-07-02', '13:40', 004, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'A009381');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-01-27', '08:00', 002, 'Santa Marta', 'University of Florence', 'Written', 'Presence', 'C583013');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2022-02-21', '08:30', 001, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'C583013');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2024-01-17', '08:00', 112, 'Santa Marta', 'University of Florence', 'Oral', 'Presence', 'B043910');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2024-02-01', '08:30', 031, 'Santa Marta', 'University of Florence', 'Written', 'Presence', 'B043910');

INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-06-29', '09:00', 005, 'Centro Didattico Morgagni', 'University of Florence', 'Written', 'Presence', 'B184721');
INSERT INTO Appeals (Date, StartTime, Room, UniversityComplex, University, Note, Mode, CodeCourse) VALUES ('2023-07-21', '14:30', 104, 'Centro Didattico Morgagni', 'University of Florence', 'Oral', 'Presence', 'B184721');


-- insert student careers
INSERT INTO StudentCareers (StudentFreshman) VALUES (7328102); --2021
INSERT INTO StudentCareers (StudentFreshman) VALUES (9302912); --2021
INSERT INTO StudentCareers (StudentFreshman) VALUES (3920391); -- 2020
INSERT INTO StudentCareers (StudentFreshman) VALUES (3923920); --2019 finish
INSERT INTO StudentCareers (StudentFreshman) VALUES (3820392); --2019
INSERT INTO StudentCareers (StudentFreshman) VALUES (4728103); --2019
INSERT INTO StudentCareers (StudentFreshman) VALUES (0102829); --2020
INSERT INTO StudentCareers (StudentFreshman) VALUES (7028492); --2020


-- insert study plans
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (7328102, 'C583013', 'Accredited', '2021-09-14');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (7328102, 'B032592', 'Registered', '2022-09-14');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (7328102, 'B056592', 'Registered', '2022-12-10');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (9302912, 'C583013', 'Accredited', '2021-09-10');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (9302912, 'B056592', 'Attended', '2022-01-08');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (9302912, 'B087292', 'Accredited', '2022-01-08');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3920391, 'B020392', 'Accredited', '2020-01-09');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3920391, 'C043352', 'Accredited', '2022-12-22');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3923920, 'B002849', 'Accredited', '2019-09-15');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3923920, 'C043352', 'Accredited', '2020-11-29');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3923920, 'C583013', 'Accredited', '2021-01-02');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3820392, 'B002849', 'Accredited', '2019-12-01');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3820392, 'B020392', 'Accredited', '2020-12-30');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (3820392, 'A009381', 'Accredited', '2021-12-30');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4728103, 'C003830', 'Accredited', '2019-08-30');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4728103, 'C043352', 'Accredited', '2020-12-05');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (4728103, 'A009381', 'Accredited', '2021-11-20');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (0102829, 'C583013', 'Attended', '2021-01-09');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (0102829, 'B087592', 'Attended', '2022-12-22');

INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (7028492, 'B043910', 'Registered', '2023-01-09');
INSERT INTO StudyPlans (StudentFreshman, CodeCourse, State, RegistrationDate) VALUES (7028492, 'B087592', 'Accredited', '2022-12-22');



-- insert appeal participation
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (7328102, 21, '17');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (7328102, 22, '25');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (9302912, 21, '15');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (9302912, 22, '27');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (9302912, 10, '30L');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (9302912, 6, null);

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3920391, 17, '23');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3920391, 16, '21');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3923920, 11, '28');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3923920, 15, '29');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3923920, 22, '29');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3820392, 11, 'Retired');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3820392, 12, '25');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3820392, 17, '28');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3820392, 19, '16');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (3820392, 20, '27');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (4728103, 13, '20');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (4728103, 16, '24');
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (4728103, 19, '22');

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (0102829, 22, null);
INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (0102829, 7, null);

INSERT INTO AppealParticipation (StudentFreshman, IdAppeal, Vote) VALUES (7028492, 7, '30');







