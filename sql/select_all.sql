SELECT
  ss.id     AS 'Song ID',
  s.name    AS 'Song',
  al.name   AS 'Album',
  au.name   AS 'Author',
  g.name    AS 'Genre',
  ml.name   AS 'Label',
  u.uid     AS 'User ID',
  username  AS 'Username',
  email     AS 'Email'
FROM saved_song     AS ss
JOIN song           AS s  ON s.id  = ss.sid
JOIN user           AS u  ON u.uid = ss.uid
JOIN genre          AS g  ON g.id  = s.genre_id
JOIN album          AS al ON al.id = s.album_id
JOIN author         AS au ON au.id = s.author_id
JOIN musical_label  AS ml ON ml.id = al.musical_label_id;

