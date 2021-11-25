USE kafedra;

DROP FUNCTION IF EXISTS get_avg_semester;

DELIMITER $$
CREATE FUNCTION get_avg_semester()
RETURNS int
READS SQL DATA
BEGIN
  RETURN (SELECT AVG(semester) FROM discipline);
END $$
DELIMITER ;


CREATE OR REPLACE VIEW less_avg_semester AS
  SELECT * FROM discipline WHERE semester < get_avg_semester();


DROP FUNCTION IF EXISTS get_academic_status_from_employee;

DELIMITER $$
CREATE FUNCTION get_academic_status_from_employee(eid int)
RETURNS varchar(99)
READS SQL DATA
BEGIN
  RETURN (SELECT s.name
          FROM employee as e
          JOIN academic_status as s ON e.status = s.id
          WHERE e.id = eid);
END $$
DELIMITER ;


CREATE OR REPLACE VIEW get_employees_academic_statuses AS
  SELECT first_name, name,
         get_academic_status_from_employee(id) as status
  FROM employee;

