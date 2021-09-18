/* Creates iTunes DB */

CREATE DATABASE IF NOT EXISTS itunes;

use itunes;

CREATE TABLE IF NOT EXISTS user (
  uid               int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  username          varchar(64) NOT NULL,
  email             varchar(99) NOT NULL,
  password          varchar(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS author (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name              varchar(99)
);

CREATE TABLE IF NOT EXISTS musical_label (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name              varchar(99) NOT NULL
);

CREATE TABLE IF NOT EXISTS album (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name              varchar(99) NOT NULL,
  author_id         int         NOT NULL,
  label_id          int         NOT NULL,

  FOREIGN KEY (author_id) REFERENCES author(id),
  FOREIGN KEY (label_id) REFERENCES musical_label(id)
);

CREATE TABLE IF NOT EXISTS genre (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name              varchar(99) NOT NULL
);

CREATE TABLE IF NOT EXISTS song (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name              varchar(99) NOT NULL,
  genre_id          int         NOT NULL,
  album_id          int         NOT NULL,
  price             int         DEFAULT 1,
  downloads         int         DEFAULT 0,

  FOREIGN KEY (author_id) REFERENCES author(id),
  FOREIGN KEY (genre_id) REFERENCES genre(id),
  FOREIGN KEY (album_id) REFERENCES album(id)
);

CREATE TABLE IF NOT EXISTS saved_song (
  id                int         PRIMARY KEY AUTO_INCREMENT NOT NULL,
  uid               int         NOT NULL,
  sid               int         NOT NULL,

  FOREIGN KEY (uid) REFERENCES user(uid),
  FOREIGN KEY (sid) REFERENCES song(id)
);

