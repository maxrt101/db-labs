DROP DATABASE IF EXISTS kafedra;
CREATE DATABASE kafedra;
USE kafedra;

CREATE TABLE position (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        varchar(99) NOT NULL
);

CREATE TABLE academic_status (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        varchar(99) NOT NULL
);

CREATE TABLE degree (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        varchar(99) NOT NULL
);

CREATE TABLE acceptance_form (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        varchar(99) NOT NULL
);

CREATE TABLE discipline (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        varchar(99) NOT NULL,
  semester    int NOT NULL,
  code        int NOT NULL,
  form        int NOT NULL
);

CREATE TABLE employee (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  first_name  varchar(99) NOT NULL,
  name        varchar(99) NOT NULL,
  birthday    date NOT NULL,
  passport    varchar(99) NOT NULL,
  expirience  int NOT NULL,
  position    int NOT NULL,
  status      int NOT NULL,
  degree      int NOT NULL
);

CREATE TABLE employee_discipline (
  id          int PRIMARY KEY AUTO_INCREMENT NOT NULL,
  employee    int NOT NULL,
  discipline  int NOT NULL
);

