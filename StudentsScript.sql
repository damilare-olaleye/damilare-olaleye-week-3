-- Creating a Table called students
CREATE TABLE students (
	-- This is a comment
	-- when creating a table, we need to specify the columns that we want
	-- The format is <column_name> <data type> <constraints> 
	student_id INTEGER PRIMARY KEY, 
	student_first_name VARCHAR(255) NOT NULL,
	student_last_name VARCHAR(255) NOT NULL, 
	student_classification VARCHAR(20) NOT NULL,
	student_age INTEGER NOT NULL
);

-- Inserting two rows into the students table
INSERT INTO students(student_id, student_first_name, student_last_name, student_classification, student_age)
VALUES
(1, 'John', 'Doe', 'Freshman', 18),
(2, 'Jane', 'Doe', 'Senior', 22);

-- Querying all columns from the students table
SELECT *
FROM STUDENTS;

-- Query specific columns
-- student_id, student_first_name, student_last_name
SELECT student_id, student_first_name, student_last_name
FROM students 

-- Querying a specific student from students
SELECT *
FROM students
WHERE student_id = 2;