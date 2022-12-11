DROP SCHEMA IF EXISTS oc_schema;
CREATE SCHEMA oc_schema;

USE oc_schema;

CREATE TABLE cycles (
             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             numbers VARCHAR(64) NOT NULL,
             year VARCHAR(64) NOT NULL,
             description VARCHAR(2000) NOT NULL
);

CREATE TABLE facultymembers (
            id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(64) NOT NULL,
            surname VARCHAR(64) NOT NULL,
            specialization VARCHAR(64) NOT NULL,
            institution VARCHAR(64) NOT NULL
);

CREATE TABLE students(
             id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             name VARCHAR(64) NOT NULL,
             surname VARCHAR(64) NOT NULL,
             topics VARCHAR(64) NOT NULL
);

-- find a better name
CREATE TABLE facultymembers_cycle (
              id_cycle INT NOT NULL REFERENCES cycles (id),
              id_facultymember INT NOT NULL REFERENCES facultymembers (id),
              PRIMARY KEY (id_cycle, id_facultymember)
);
-- find a better name
CREATE TABLE students_cycle (
            id_cycle INT NOT NULL REFERENCES cycles (id),
            id_student INT NOT NULL REFERENCES students (id),
            PRIMARY KEY (id_cycle, id_student)
);

CREATE TABLE advisors(
            id_facultymember INT NOT NULL REFERENCES facultymembers (id),
            id_student INT NOT NULL REFERENCES students (id),
            PRIMARY KEY (id_facultymember, id_student)
);

