USE do_schema;
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`) VALUES ('1', 'Fuffologia Applicata', 'descrcourse1', '3', '2000');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`) VALUES ('2', 'Software della fuffa', 'descrcourse2', '3', '2000');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`) VALUES ('3', 'Fuffa AI', 'descrcourse3', '3', '2000');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`) VALUES ('4', 'Fuffa Vision', 'descrcourse4', '6', '2000');

INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`, CodeCourse) VALUES ('2231', 'DocName1', 'DocSurn1', 'SpecDoc1', 'Univ1', 'mail1', 'pass1', '1');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`, CodeCourse) VALUES ('4637', 'DocName2', 'DocSurn2', 'SpecDoc2', 'Univ1', 'mail2', 'pass2', '2');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`, CodeCourse) VALUES ('9344', 'DocName3', 'DocSurn3', 'SpecDoc3', 'Univ2', 'mail3', 'pass3', '3');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`, CodeCourse) VALUES ('2983', 'DocName4', 'DocSurn4', 'SpecDoc4', 'Univ2', 'mail4', 'pass4', '4');

