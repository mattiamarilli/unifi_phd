USE oc_schema;

INSERT INTO Cycles (Number, Year, Description) VALUES ('XXVI', 2019, 'Information Technology, Systems and Telecommunications');
INSERT INTO Cycles (Number, Year, Description) VALUES ('XXVII', 2020, 'IComputer and automation engineering');
INSERT INTO Cycles (Number, Year, Description) VALUES ('XXVIII', 2021, 'Automatic and Optimization');
INSERT INTO Cycles (Number, Year, Description) VALUES ('XXIX', 2022, 'Telematics and information society');
INSERT INTO Cycles (Number, Year, Description) VALUES ('XXX', 2023, 'Electronics and electromagnetism');

INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (5849204, 'Sayal', 'Dais', 'sayal.dais@gmail.com', 'Password', 'Smart Living, Cyber-Physical Systems, Sensor and IoT Networking', 'Missouri University of Science and Technology', 'XXVI');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (0593183, 'Gianluca', 'Dini', 'gianluca.dini@unipi.it', 'Password', 'Distributed systems; Cyber-security', 'University of Pisa', 'XXVI');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (3840149, 'Paolo', 'Fresconi', 'paolo.fresconi@unifi.it', 'Password', 'Machine Learning; Bioinformatics', 'University of Florence', 'XXVIII');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (0281392, 'Marco', 'Gori', 'marco.gori@unisi.it', 'Password', 'Machine Learning; Computer Vision', 'University of Siena', 'XXVII');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (5739219, 'Witold', 'Pedrycz', 'witold.pedrycz@gmail.com', 'Password', 'Computational Intelligence, fuzzy modeling, Granular Computing, knowledge discovery', 'University of Alberta', 'XXVIII');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (5749249, 'Franco', 'Scarselli', 'franco.scarselli@unisi.it', 'Password', 'Machine Learning; Artificial neural networks', 'University of Siena', 'XXVII');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (0427190, 'Giovanni', 'Stea', 'giovanni.stea@unipi.it', 'Password', 'Networking; Quality of Service; Performance Evaluation', 'University of Pisa', 'XXIX');
INSERT INTO FacultyMembers (Freshman, Name, Surname, Email, Password, Specialization, Institution, Cycle) VALUES (0093821, 'Monica', 'Bianchini', 'monica.bianchini@unisi.it', 'Password', 'Machine learning', 'University of Siena', 'XXX');

INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (7328102, 'Luca', 'Biandini', 'luca.biandini@unifi.it', 'Password', '', 'XXVIII', 2, 3840149);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (9302912, 'Federico', 'Nocentini', 'federico.nocentini@unifi.it', 'Password', '', 'XXVIII', 2, 5739219);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (3920391, 'Lorenzo', 'Agnolucci', 'lorenzo.agnolucci@unifi.it', 'Password', '', 'XXVII', 3, 0281392);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (3923920, 'Alessandro', 'Betti', 'alessandro.betti@unifi.it', 'Password', '', 'XXVI', 4);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (3820392, 'Alessandro', 'Danieli', 'alessandro.danieli@unifi.it', 'Password', '', 'XXVI', 4);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year) VALUES (4728103, 'Enrico', 'Meloni', 'enrico.meloni@unifi.it', 'Password', 'Machine Learning and Explainable AI', 'XXVI', 4);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (0102829, 'Tommaso', 'Aldinucci', 'tommaso.aldinucci@unifi.it', 'Password', 'TBD', 'XXVII', 3, 5749249);
INSERT INTO Students (Freshman, Name, Surname, Email, Password, Topics, Cycle, Year, Advisor) VALUES (7028492, 'Matteo', 'Barbetti', 'matteo.barbetti@unifi.it', 'Password', 'Smart Computing Techniques applied to Medical Physics, Nuclear Physics and Particle Physics', 'XXVII', 3, 0281392);

