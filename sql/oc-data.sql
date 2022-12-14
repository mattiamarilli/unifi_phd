USE oc_schema;

INSERT INTO `cycles` (`number`, `year`, `description`) VALUES ('1', '2000', '\"this is the first edition\"');
INSERT INTO `cycles` (`number`, `year`, `description`) VALUES ('2', '2001', '\"this is the second edition\"');
INSERT INTO `cycles` (`number`, `year`, `description`) VALUES ('3', '2002', '\"this is the third edition\"');

INSERT INTO `students` (`id`,`name`, `surname`, `topics`) VALUES ('8283','Pippo', 'Rossi', 'SWE');
INSERT INTO `students` (`id`,`name`, `surname`, `topics`) VALUES ('9292','Paperino', 'Bianchi', 'AI');
INSERT INTO `students` (`id`,`name`, `surname`, `topics`) VALUES ('8222','Minnie', 'Verdi', 'deep learning');
INSERT INTO `students` (`id`,`name`, `surname`, `topics`) VALUES ('2345','Zio', 'Paperone', 'make money');

INSERT INTO `facultymembers` (`id`,`name`, `surname`, `specialization`, `institution`) VALUES ('345','Mario', 'Rossi', 'Spec1', 'istit1');
INSERT INTO `facultymembers` (`id`,`name`, `surname`, `specialization`, `institution`) VALUES ('112','Luca', 'Bianchi', 'Spec2', 'istit2');
INSERT INTO `facultymembers` (`id`,`name`, `surname`, `specialization`, `institution`) VALUES ('321','Giovanni', 'Verdi', 'Spec3', 'istit3');
INSERT INTO `facultymembers` (`id`,`name`, `surname`, `specialization`, `institution`) VALUES ('453','Francesco', 'Giallo', 'Spec4', 'istit4');

INSERT INTO `facultymembers_cycle` (`number_cycle`, `id_facultymember`) VALUES ('1', '345');
INSERT INTO `facultymembers_cycle` (`number_cycle`, `id_facultymember`) VALUES ('1', '112');
INSERT INTO `facultymembers_cycle` (`number_cycle`, `id_facultymember`) VALUES ('2', '321');
INSERT INTO `facultymembers_cycle` (`number_cycle`, `id_facultymember`) VALUES ('3', '453');

INSERT INTO `students_cycle` (`number_cycle`, `id_student`) VALUES ('1', '8283');
INSERT INTO `students_cycle` (`number_cycle`, `id_student`) VALUES ('1', '9292');
INSERT INTO `students_cycle` (`number_cycle`, `id_student`) VALUES ('2', '8222');
INSERT INTO `students_cycle` (`number_cycle`, `id_student`) VALUES ('3', '2345');

INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('345', '8283');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('112', '9292');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('321', '8222');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('453', '2345');