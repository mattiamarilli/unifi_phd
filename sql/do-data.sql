USE do_schema;

INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`) VALUES ('2231', 'DocName1', 'DocSurn1', 'SpecDoc1', 'Univ1', 'mail1', 'pass1');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`) VALUES ('4637', 'DocName2', 'DocSurn2', 'SpecDoc2', 'Univ1', 'mail2', 'pass2');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`) VALUES ('9344', 'DocName3', 'DocSurn3', 'SpecDoc3', 'Univ2', 'mail3', 'pass3');
INSERT INTO `Professors` (`Freshman`, `Name`, `Surname`, `Specialization`, `University`, `Email`, `Password`) VALUES ('2983', 'DocName4', 'DocSurn4', 'SpecDoc4', 'Univ2', 'mail4', 'pass4');

INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`, `ProfessorFreshman`) VALUES ('1', 'Fuffologia Applicata', 'descrcourse1', '3', '2000', '2231');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`, `ProfessorFreshman`) VALUES ('2', 'Software della fuffa', 'descrcourse2', '3', '2000', '4637');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`, `ProfessorFreshman`) VALUES ('3', 'Fuffa AI', 'descrcourse3', '3', '2000', '9344');
INSERT INTO `Courses` (`Code`, `Title`, `Description`, `CFU`, `Year`, `ProfessorFreshman`) VALUES ('4', 'Fuffa Vision', 'descrcourse4', '6', '2000', '2983');
