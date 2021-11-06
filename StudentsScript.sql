-- grades table
DROP TABLE IF EXISTS grades;

CREATE TABLE grades (
	grade_id SERIAL PRIMARY KEY,
	grade INTEGER NOT NULL,
	assignment_name VARCHAR(100) NOT NULL,
	student_id INTEGER NOT NULL, 
	
	CONSTRAINT fk_student FOREIGN KEY(student_id)
		REFERENCES students(student_id)
);

INSERT INTO grades (grade, assignment_name, student_id)
VALUES 
(85, 'homework 1.1', 1), 
(90, 'homework 1.1', 2), 
(93, 'homework 1.2', 1), 
(92, 'homework 1.2', 2)

SELECT *
FROM grades 

/*
 *  Refrential Integrity:
 * 
 * 	Whenever we create relationships between tables, such as by having a foreign key in one table link to a primary key in another table,
 *  SQL ensures that orphan records can never occur. SQL preserves this idea of having integrity with respect to references.
 */

-- To drop table students we will need to drop table grades first
DROP TABLE grades 

DROP TABLE students 
-- I cannot drop the students table, becasue the grades table has a foreign key that references a primary key in the students table
-- so, grades is dependent on students
-- If I wanted to drp the students table, I would need to drop the grades table first, and then drop the students table 

DELETE FROM students 
WHERE student_id  = 1;
-- I cannot delete student 1, because theere are two grades that belong to student 1
-- I would need to delete the grades that belong to student 1, before I can delete student 1

/**
 * ACID properties: this an acronym for the properties of transactions
 * 
 * Atomicity: The transactions entirely succeeds or not at all
 * Consistency: Constriants and referential integrity must be upheld by a transaction. A transaction cannot violate the constraints
 * Isolation: Tow transactions should not be interfering with each other as they are happening in a concurrent situation
 * Durability: Once a transaction has been committed, those changes are permaneyly stored in the database's storage memeory instead of RAM
 * Transaction: a grouping of DML statement that we would like to treat as a single operation
 * - Transactions are either
 * 1. commited using the COMMIT statement
 * 2. rolled back using the ROLLBACK statement
 * 
 * However, by default, we don't need to do this whenever we work with DML statements
 * 	BECAUSE AUTOCOMMIT is turned on by default
 * 
 * So, to demostrate transaction in more details, we will turn off autocommit
 * 
 * We can do this using the setting in Dbeaver
 */

SELECT * 
FROM students 

SELECT * 
FROM grades 

-- DML Operations: INSERT, UUPDATE, DELETE
-- However, we don't really need to commit or rollback SELECT, because SELECT doesn't really make any changes to our database

DELETE GROM grades
WHERE grade_id = 3;

ROLLBACK; -- can only be used before you commit a transaction's changes. Rollback will go back to the state before the transaction began

DELETE GROM grades
WHERE grade_id = 4;

INSERT INTO grades(grade, assignment_name, student_id)
VALUES (100, 'Midterm 1', 1);

CHECKPOINT 

-- permanetly gone with COMMMIT
COMMIT; -- Once you run the COMMIT, changes made in a particular transaction will become permanent

/*
 * Scalar and Aggregate functions
 * 
 * Scalar Function: a function that acts on individual rows of data
 * Aggregate Function: a function that acts on many rows of data and gives a single value as output
 */

-- LENGTH is a scalar function 
SELECT student_first_name, LENGTH(student_last_name), student_last_name, LENGTH(student_last_name)
FROM students;

-- AVG is an aggregate function
SELECT AVG(student_age)
FROM students;

SELECT * 
FROM GRADES 

INSERT INTO grades (grade, assignment_name, student_id)
VALUES
(85, 'Homework 1.2', 1);
(85, 'Midterm 1', 2);
(85, 'Homework 1.2', 1);
(85, 'Midterm 2', 2);

-- This will average together all of the grade values from the grades tables
-- But, because we have homework 1.1 and Midterm 1, it probably doesn't make too much sense to average these two different
SELECT AVG(grades)
FROM grades;

-- What instead?
SELECT assignment_name, AVG(grade)
FROM grades 
GROUP BY assignment_name; -- GROUP BY will create different groups based on that column having the same value 
-- So, we have Group 1: homework1.1
-- And Group 2: Midterm 1
-- It will find the average within those individual groups instead of finding the entire average








DROP TABLE IF EXISTS books;

CREATE TABLE books (
	book_id SERIAL PRIMARY KEY, 
	isbn VARCHAR(20) NOT NULL,
	book_name VARCHAR(255),
	author VARCHAR(255)
);

SELECT * FROM books; 

INSERT INTO books(isbn, book_name, author) values ('1828hsjdwe23', 'Harry Potter', 'JK Rowling');

UPDATE books 
	SET isbn = '1828hsjdwe2322',
	 book_name  = 'Harry Potter',
	 author = 'JK Rowling'
WHERE 
	book_id = 2;


DROP TABLE IF EXISTS students;
-- Creating a Table called students
CREATE TABLE students (
	-- This is a comment
	-- when creating a table, we need to specify the columns that we want
	-- The format is <column_name> <data type> <constraints> 
	student_id SERIAL PRIMARY KEY, -- SERIAL; defines the an INTEGER type that increments automatically on its own
	student_first_name VARCHAR(255) NOT NULL,
	student_last_name VARCHAR(255) NOT NULL, 
	student_classification VARCHAR(20) NOT NULL,
	student_age INTEGER NOT NULL
);

-- Inserting two rows into the students table
INSERT INTO students
	(student_first_name, student_last_name, student_classification, student_age)
VALUES
('John', 'Doe', 'Freshman', 18),
('Jane', 'Doe', 'Senior', 22);

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

-- Data Manipulation languge (INSERT, SELECT, UPDATE, DELETE)

UPDATE students 
	SET student_first_name = 'Megan',
	 student_last_name  = 'Do',
	 student_classification = 'Sophmore',
	 student_age  = 19
WHERE 
	student_id = 5;

	
DELETE 
FROM students 
WHERE student_id = 5;

DELETE 
FROM students ;