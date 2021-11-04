package com.revature.service;

import java.sql.SQLException;

import com.revature.dao.StudentDao;
import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Student;

public class StudentService {
	

	private StudentDao studentDao; // HAS-A relationship. StudentService HAS-A StudentDAO
	// In other words, StudentService depends on StudentDAO
	// StudentDAO is a dependency of StudentService
	
	// The word dependency has many meanings in programming and technology in general
	// 1. Maven dependency: an API of sort that we are using inside of our own Maven project (Javalin, Postgres Driver, JUnit 5)
	// 2. Object dependencies (ex. a StudentService object depends on a StudentDAO object
	
	public StudentService() {
		this.studentDao = new StudentDao();
	}
	/*
	 * 
	 * This is our service layer logic for updating ONLY the firstName of a student
	 * 
	 * What this method does is first grab the Student with that particular student id from the database
	 * 	- If a student does not exist with that studentID, it will throw a StudentNotFoundException
	 * 	- Otherwise, it will go ahead and call the updateStudent method in the DAO layer and provide the appropiate arguements. 
	 */
	
	// What if I only want to edit the first name of a person?
	public Student editFirstNameOfStudent(int studentId, String changedName) throws SQLException, StudentNotFoundException {
		
		// First, grab the information about the student with a student id of the value studentId
		Student studentToEdit = this.studentDao.getStudentById(studentId);
		
		// How does getStudentById work?
		//1nd scenario: If we have a studentId that indeed exists in the database, it will return us a Student containing the information
		//2nd scenario: If we have a studentId that does not have corresponding record in the database, it will return nul
		
		if (studentToEdit == null) {
			throw new StudentNotFoundException("Student with an id of " + studentId + " was not found");
		}
		
		// This DTO will contain the first name that will be changed while everything else stays the same as before
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO(changedName, studentToEdit.getLastName(), studentToEdit.getClassfication(), studentToEdit.getAge());
		// This DTO object contains the firstName, the lastName, the Classification, and the age that we want to update the student to
		// populated from the Student object we grabbed from the database (using getStudnetById)
		
		Student updatedStudent = this.studentDao.updateStudent(studentId, dto);
		
		return updatedStudent;
	}
}
