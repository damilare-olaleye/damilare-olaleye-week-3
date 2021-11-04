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
	 author = 'JK Rowling',
WHERE 
	student_id = 2;


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