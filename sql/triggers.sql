
DROP TRIGGER IF EXISTS discipline_insert;

DELIMITER $$
CREATE TRIGGER discipline_insert
BEFORE INSERT
ON discipline 
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table discipline: This id is already present";
  END IF;
  IF (new.form NOT IN (SELECT id FROM acceptance_form)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table discipline: No such id in table acceptance_form";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS discipline_update;

DELIMITER $$
CREATE TRIGGER discipline_update
BEFORE UPDATE
ON discipline
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table discipline: This id is already present";
  END IF;
  IF (new.form NOT IN (SELECT id FROM acceptance_form)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table discipline: No such id in table acceptance_form";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS employee_insert;

DELIMITER $$
CREATE TRIGGER employee_insert
BEFORE INSERT
ON employee
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee: This id is already present";
  END IF;
  IF (new.position NOT IN (SELECT id FROM position)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee: No such id in table position";
  END IF;
  IF (new.status NOT IN (SELECT id FROM academic_status)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee: No such id in table academic_status";
  END IF;
  IF (new.degree NOT IN (SELECT id FROM degree)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee: No such id in table degree";
  END IF;
  IF (new.expirience > (NOW() - new.birthday + 15)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee: Expirience is not possible`";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS employee_update;

DELIMITER $$
CREATE TRIGGER employee_update
BEFORE UPDATE
ON employee
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee: This id is already present";
  END IF;
  IF (new.position NOT IN (SELECT id FROM position)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee: No such id in table position";
  END IF;
  IF (new.status NOT IN (SELECT id FROM academic_status)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee: No such id in table academic_status";
  END IF;
  IF (new.degree NOT IN (SELECT id FROM degree)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee: No such id in table degree";
  END IF;
  IF (new.expirience > (YEAR(NOW()) - YEAR(new.birthday) + 15)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee: Expirience is not possible`";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS employee_delete;

DELIMITER $$
CREATE TRIGGER employee_delete
BEFORE DELETE
ON employee
FOR EACH ROW
BEGIN
  IF (old.id IN (SELECT id FROM employee_discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Delete failed for table employee: No such id in table employee_discipline";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS position_insert;

DELIMITER $$
CREATE TRIGGER position_insert
BEFORE INSERT
ON position
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM position)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table position: This id is already present";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS status_insert;

DELIMITER $$
CREATE TRIGGER status_insert
BEFORE INSERT
ON academic_status
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM academic_status)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table academic_status: This id is already present";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_insert;

DELIMITER $$
CREATE TRIGGER degree_insert
BEFORE INSERT
ON degree
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM degree)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table degree: This id is already present";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS position_update;

DELIMITER $$
CREATE TRIGGER position_update
BEFORE UPDATE
ON position
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM position)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table position: This id is already present";
  END IF;
  IF (old.id IN (SELECT position FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table position: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS status_update;

DELIMITER $$
CREATE TRIGGER status_update
BEFORE UPDATE
ON academic_status
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM academic_status)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table academic_status: This id is already present";
  END IF;
  IF (old.id IN (SELECT status FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table status: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_update;

DELIMITER $$
CREATE TRIGGER degree_update
BEFORE UPDATE
ON degree
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM degree)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table degree: This id is already present";
  END IF;
  IF (old.id IN (SELECT degree FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table degree: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS position_delete;

DELIMITER $$
CREATE TRIGGER position_delete
BEFORE DELETE
ON position
FOR EACH ROW
BEGIN
  IF (old.id IN (SELECT position FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Delete failed for table position: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS status_delete;

DELIMITER $$
CREATE TRIGGER status_delete
BEFORE DELETE
ON academic_status
FOR EACH ROW
BEGIN
  IF (old.id IN (SELECT status FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Delete failed for table status: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_delete;

DELIMITER $$
CREATE TRIGGER degree_delete
BEFORE DELETE
ON degree
FOR EACH ROW
BEGIN
  IF (old.id IN (SELECT degree FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Delete failed for table degree: There are rows in employee that are referencing this row ";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS form_insert;

DELIMITER $$
CREATE TRIGGER form_insert
BEFORE INSERT
ON acceptance_form
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM acceptance_form)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table acceptance_form: This id is already present";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS form_update;

DELIMITER $$
CREATE TRIGGER form_update
BEFORE INSERT
ON acceptance_form
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM acceptance_form)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table acceptance_form: This id is already present";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS form_delete;

DELIMITER $$
CREATE TRIGGER form_delete
BEFORE DELETE
ON acceptance_form
FOR EACH ROW
BEGIN
  IF (old.id NOT IN (SELECT form FROM discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Delete failed for table acceptance_form: There are rows in discipline that are referencing this row";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS employee_discipline_insert;

DELIMITER $$
CREATE TRIGGER employee_discipline_insert
BEFORE INSERT
ON employee_discipline
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM employee_discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table employee_discipline: This id is already present";
  END IF;
  IF (new.employee NOT IN (SELECT id FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table position: There are bo such id in table employee";
  END IF;
  IF (new.discipline NOT IN (SELECT id FROM discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Insert failed for table position: There are bo such id in table discipline";
  END IF;
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS employee_discipline_update;

DELIMITER $$
CREATE TRIGGER employee_discipline_update
BEFORE UPDATE
ON employee_discipline
FOR EACH ROW
BEGIN
  IF (new.id IN (SELECT id FROM employee_discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table employee_discipline: This id is already present";
  END IF;
  IF (new.employee NOT IN (SELECT id FROM employee)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table position: There are bo such id in table employee";
  END IF;
  IF (new.discipline NOT IN (SELECT id FROM discipline)) THEN
    SIGNAL SQLSTATE "45000"
    SET MESSAGE_TEXT = "Update failed for table position: There are bo such id in table discipline";
  END IF;
END $$
DELIMITER ;

