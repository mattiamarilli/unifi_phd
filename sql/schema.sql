DROP SCHEMA IF EXISTS unifi_phd;
CREATE SCHEMA unifi_phd;

USE unifi_phd;

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