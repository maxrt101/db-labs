USE kafedra;

DROP PROCEDURE IF EXISTS insert_into_disciplines;

DELIMITER $$
CREATE PROCEDURE insert_into_disciplines (
  name varchar(99),
  semester int,
  code int,
  form int
)
BEGIN
  INSERT INTO discipline VALUES (name, semerter, code, form);
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS print_employee_discipline;

DELIMITER $$
CREATE PROCEDURE print_employee_discipline (
  name varchar(99)
)
BEGIN
  SELECT
    d.name,
    d.semester,
    d.form,
    e.first_name,
    e.name,
    e.position,
    e.status,
    e.degree
  FROM employee_discipline as ed
  JOIN employee as e ON ed.employee = e.id
  JOIN discipline  as d ON ed.discipline = d.id
  WHERE
    CASE
      WHEN name != '' AND e.name = name THEN 1
      WHEN name  = '' THEN 1
    END;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS create_discipline_table;

DELIMITER $$
CREATE PROCEDURE create_discipline_table(table_name varchar(99))
BEGIN
  SET @query = CONCAT(
    'CREATE TABLE IF NOT EXISTS ', table_name, ' (',
      'id int PRIMARY KEY AUTO_INCREMENT NOT NULL,',
      'name varchar(99) NOT NULL,',
      'semester int NOT NULL,',
      'code int NOT NULL,',
      'form int NOT NULL)');
  PREPARE stmt FROM @query;
  EXECUTE stmt;
  DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS create_random_discipline_tables;

DELIMITER $$
CREATE PROCEDURE create_random_discipline_tables ()
BEGIN
  DECLARE d_id, d_semester, d_code, d_form int;
  DECLARE d_name varchar(99);
  DECLARE table1, table2 varchar(99);

  DECLARE done int DEFAULT 0;
  DECLARE cur CURSOR FOR
    SELECT id, name, semester, code, form from discipline;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
  
  SET table1 = CONCAT('discipline_0_', UNIX_TIMESTAMP());
  SET table2 = CONCAT('discipline_1_', UNIX_TIMESTAMP());

  CALL create_discipline_table(table1);
  CALL create_discipline_table(table2);

  OPEN cur;

  WHILE done = 0 DO
    FETCH cur INTO d_id, d_name, d_semester, d_code, d_form;
    IF done = 0 THEN
      IF FLOOR(RAND() * 10) % 2 THEN
        SET @table_name = table1;
      ELSE
        SET @table_name = table2;
      END IF;
      SET @query = CONCAT('INSERT INTO ', @table_name, ' VALUES ("',
        d_id, '", "',
        d_name, '", "',
        d_semester, '", "',
        d_code, '", "',
        d_form, '")');
      PREPARE stmt FROM @query;
      EXECUTE stmt;
      DEALLOCATE PREPARE stmt;
    END IF;
  END WHILE;

  CLOSE cur;
END $$
DELIMITER ;

