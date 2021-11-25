USE kafedra;

INSERT INTO position (name) VALUES 
  ('Vykladach'),
  ('Dyrektor'),
  ('Zam Dyrektora');

INSERT INTO academic_status (name) VALUES
  ('None'),
  ('Docent'),
  ('Professor'),
  ('Doktor');

INSERT INTO degree (name) VALUES
  ('None'),
  ('k.t.n.'),
  ('d.t.n.');

INSERT INTO acceptance_form (name) VALUES
  ('ekzamen'),
  ('zalik');

INSERT INTO employee (first_name, name, birthday, passport, expirience, position, status, degree) VALUES
  ('Veres',     'Zenoviy', date('1875.09.14'), 'UA 12345678', 100, 2, 3, 3),
  ('Nytrebych', 'Zenoviy', date('1961.05.27'), 'UA 87654321',  60, 1, 3, 3);

INSERT INTO discipline (name, semester, code, form) VALUES
  ('AP-1', 1, 127, 1),
  ('AP-2', 2, 128, 1),
  ('AP-3', 3, 129, 1),
  ('Math-1', 1, 250, 1),
  ('Math-2', 2, 251, 1),
  ('Math-3', 3, 252, 2),
  ('English-1', 1, 300, 1),
  ('English-2', 2, 301, 2),
  ('English-3', 3, 302, 2);

INSERT INTO employee_discipline (employee, discipline) VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (2, 4),
  (2, 5),
  (2, 6),
  (1, 7),
  (2, 8),
  (1, 9);

