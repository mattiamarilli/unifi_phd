USE oc_schema;

INSERT INTO `cycles` (`numbers`, `year`, `description`) VALUES ('1', '2000', '\"awsome description\"');
INSERT INTO `cycles` (`numbers`, `year`, `description`) VALUES ('2', '2001', '\"awsome description\"');
INSERT INTO `cycles` (`numbers`, `year`, `description`) VALUES ('3', '2002', '\"awsome description\"');

INSERT INTO `students` (`name`, `surname`, `topics`) VALUES ('Pippo', 'Rossi', 'SWE');
INSERT INTO `students` (`name`, `surname`, `topics`) VALUES ('Paperino', 'Bianchi', 'AI');
INSERT INTO `students` (`name`, `surname`, `topics`) VALUES ('Minnie', 'Verdi', 'deep learning');
INSERT INTO `students` (`name`, `surname`, `topics`) VALUES ('Zio', 'Paperone', 'make money');

INSERT INTO `facultymembers` (`name`, `surname`, `specialization`, `institution`) VALUES ('Mario', 'Rossi', 'Spec1', 'istit1');
INSERT INTO `facultymembers` (`name`, `surname`, `specialization`, `institution`) VALUES ('Luca', 'Bianchi', 'Spec2', 'istit2');
INSERT INTO `facultymembers` (`name`, `surname`, `specialization`, `institution`) VALUES ('Giovanni', 'Verdi', 'Spec3', 'istit3');
INSERT INTO `facultymembers` (`name`, `surname`, `specialization`, `institution`) VALUES ('Francesco', 'Giallo', 'Spec4', 'istit4');

INSERT INTO `facultymembers_cycle` (`id_cycle`, `id_facultymember`) VALUES ('1', '1');
INSERT INTO `facultymembers_cycle` (`id_cycle`, `id_facultymember`) VALUES ('1', '2');
INSERT INTO `facultymembers_cycle` (`id_cycle`, `id_facultymember`) VALUES ('2', '3');
INSERT INTO `facultymembers_cycle` (`id_cycle`, `id_facultymember`) VALUES ('3', '4');

INSERT INTO `students_cycle` (`id_cycle`, `id_student`) VALUES ('1', '1');
INSERT INTO `students_cycle` (`id_cycle`, `id_student`) VALUES ('1', '2');
INSERT INTO `students_cycle` (`id_cycle`, `id_student`) VALUES ('2', '3');
INSERT INTO `students_cycle` (`id_cycle`, `id_student`) VALUES ('3', '4');

INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('1', '1');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('2', '2');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('3', '3');
INSERT INTO `advisors` (`id_facultymember`, `id_student`) VALUES ('4', '4');