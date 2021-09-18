/* Populates iTunes DB with values */

INSERT INTO musical_label(name) VALUES
  ('Sony Music Entertainment'),
  ('Universal Music Publishing'),
  ('Warner Music Group'),
  ('Island Records'),
  ('BMG Rights Management'),
  ('ABC Paramaunt Records'),
  ('Virgin Records'),
  ('Red Hill Records'),
  ('Atlatic Records'),
  ('Def Jam Records');

INSERT INTO genre(name) VALUES
  ('Pop'),
  ('Rock'),
  ('Classical'),
  ('Blues'),
  ('Jazz'),
  ('Soul'),
  ('Dance'),
  ('Rhythm'),
  ('Rock & Roll');

INSERT INTO author(name) VALUES
  ('Mettalica'),
  ('Green Day'),
  ('Nirvana'),
  ('AC/DC'),
  ('Soundgarden'),
  ('Audioslave'),
  ('Asteroid'),
  ('RATM'),
  ('Sun Crow'),
  ('Witchcraft'),
  ('Mistmorn'),
  ('Neil Armstrong'),
  ('Ludwig van Beethoven'),
  ('The Beetles');

INSERT INTO album(name, author_id, musical_label_id) VALUES
  ('St, Anger', 1, 1),
  ('|||', 7, 2),
  ('Superunknown', 5, 3),
  ('Badmotorfinger', 5, 4),
  ('Nevermind', 3, 5),
  ('Power Up', 4, 6),
  ('Baptism by Fire', 4, 7),
  ('One', 14, 8);

INSERT INTO song(name, author_id, genre_id, album_id, price, downloads) VALUES
  ('Frantic', 1, 2, 1, 4, 100000),
  ('St. Anger', 1, 2, 1, 4, 100000),
  ('Some Kind Of Monster', 1, 2, 1, 4, 100000),
  ('Dirty Window', 1, 2, 1, 4, 100000),
  ('Invisible Kid', 1, 2, 1, 4, 100000),
  ('Sweet Amber', 1, 2, 1, 4, 100000),
  ('The Unnamed Feeling', 1, 2, 1, 4, 100000),
  ('Purify', 1, 2, 1, 4, 100000),
  ('All Within My Hands', 1, 2, 1, 4, 100000),
  ('Pale Moon', 6, 2, 2, 3, 20000),
  ('Last Days', 6, 2, 2, 3, 20000),
  ('Til Down', 6, 2, 2, 3, 20000),
  ('Wolf & Snake', 6, 2, 2, 3, 20000),
  ('Silver & Gold', 6, 2, 2, 3, 20000),
  ('Mr. Strange', 6, 2, 2, 3, 20000);

INSERT INTO user(username, email, password) VALUES
  ('maxrt', 'max.tkachuk@gmail.com', '1111'),
  ('arsiu', 'ars.siu@gmail.com', 'qwerty'),
  ('pol2003', 'pol.ole@gmail.com', '12345678'),
  ('9lpik', 'yarik2003@gmail.com', 'SuperPwd123');

INSERT INTO saved_song(uid, sid) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5),
  (1, 6),
  (1, 7),
  (1, 8),
  (1, 9),
  (1, 10),
  (1, 11),
  (2, 10),
  (2, 9),
  (2, 8),
  (2, 7),
  (2, 6),
  (2, 5),
  (2, 4),
  (2, 3),
  (2, 3),
  (3, 3),
  (3, 4),
  (3, 5),
  (3, 6),
  (3, 7),
  (3, 8),
  (3, 9),
  (3, 2),
  (3, 1),
  (4, 15),
  (4, 14),
  (4, 13),
  (4, 12),
  (4, 11),
  (4, 10),
  (4, 9),
  (4, 8),
  (4, 7);

