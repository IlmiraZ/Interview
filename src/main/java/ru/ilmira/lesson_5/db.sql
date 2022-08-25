CREATE SCHEMA `student` ;


CREATE TABLE `student`.`students` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `mark` INT NULL,
  PRIMARY KEY (`id`))
COMMENT = 'Студенты';

--Добавляем 1000 записей в таблицу Student.

DELIMITER $$
CREATE PROCEDURE insert_test_data(IN Q INT)
BEGIN
  DECLARE i INT DEFAULT 0;

  WHILE i <  Q  DO
    INSERT INTO students (id, name, mark) VALUES (id, concat('student', i), "5");    
    SET i = i + 1;
  END WHILE;
END$$
DELIMITER ;
CALL insert_test_data(1000);

DROP PROCEDURE insert_test_data;

SELECT * FROM students;

-- Фрагмент вывода, всего записей 1000
------------------------
id  | name       | mark|
------------------------
994	| student993 |	5  |
995	| student994 |	5  |
996	| student995 |	5  |
997	| student996 |	5  |
998	| student997 |	5  |
999	| student998 |	5  |
1000| student999 |	5  |
------------------------
