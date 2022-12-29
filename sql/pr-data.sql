USE pr_schema;

INSERT INTO `ProgressReports` (`Title`, `Description`, `UrlDocument`, `State`, `StudentFreshman`) VALUES ('ProgRep1', 'descr1', 'url1', 'state1', '8283');
INSERT INTO `ProgressReports` (`Title`, `Description`, `UrlDocument`, `State`, `StudentFreshman`) VALUES ('ProgRep2', 'descr2', 'url2', 'state2', '9292');
INSERT INTO `ProgressReports` (`Title`, `Description`, `UrlDocument`, `State`, `StudentFreshman`) VALUES ('ProgRep3', 'descr3', 'url3', 'state3', '8222');

INSERT INTO `Scientists` (`Freshman`, `Name`, `Surname`, `Email`, `Password`, `Description`) VALUES ('9237', 'NameRev1', 'SurnRev1', 'mail1', 'pass1', 'descr1');
INSERT INTO `Scientists` (`Freshman`, `Name`, `Surname`, `Email`, `Password`, `Description`) VALUES ('3232', 'NameRev2', 'SurnRev2', 'mail2', 'pass2', 'descr2');
INSERT INTO `Scientists` (`Freshman`, `Name`, `Surname`, `Email`, `Password`, `Description`) VALUES ('5534', 'NameRev3', 'SurnRev3', 'mail3', 'pass3', 'descr3');

INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('1', '9237');
INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('1', '3232');
INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('2', '3232');
INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('2', '5534');
INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('2', '9237');
INSERT INTO `SupervisoryCommittee` (`IdProgressReport`, `IdScientist`) VALUES ('3', '5534');
