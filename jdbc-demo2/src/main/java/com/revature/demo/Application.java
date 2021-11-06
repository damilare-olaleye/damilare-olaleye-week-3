package com.revature.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.ExceptionMappingController;

//import java.sql.SQLException;
//import java.util.List;

import com.revature.controller.StudentController;
//import com.revature.dao.BookDao;
//import com.revature.dao.StudentDao;
//import com.revature.dto.AddOrUpdateBooksDTO;
//import com.revature.dto.AddOrUpdateStudentDTO;
//import com.revature.exceptions.studentNotFoundException;
//import com.revature.model.Book;
//import com.revature.model.Student;
//import com.revature.service.StudentService;

import io.javalin.Javalin;


public class Application {

	public static void main(String[] args) {
		
		// JAVALIN APPLICATION 
		
		Javalin app = Javalin.create();
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		
		app.before(ctx -> {
			logger.info(ctx.method() + " request received to the " + ctx.path() + "endpoint");
		});
		
		StudentController controller = new StudentController();
		controller.registerEndpoints(app);
		
		ExceptionMappingController exceptionController = new ExceptionMappingController();
		exceptionController.mapExceptions(app);
		
		app.start();
		
		// Students DAO HERE

//		StudentDao studentDao = new StudentDao();
//		
//		BookDao bookDao = new BookDao();       
//		
//		StudentService studentService = new StudentService();
//		
//		// Unchecked exception throws at RunTime because we gave indication that it will throw exception, exception just doesnt happen
//		// checked exception throws at compile time 
//		try {
//			studentService.editFirstNameOfStudent(2, "Megan");
//		} catch (SQLException  | studentNotFoundException e) {
//			e.printStackTrace();
//		} 
//		System.out.println("Our application is still running past the previous lines of code, and therefore nothing crashed");
//		
//		
//		try {
//			List<Student> results = studentDao.getAllStudents();
//			System.out.println(results);
//			
//			Student s = studentDao.getStudentById(1);
//			System.out.println(s);
//			
//			AddOrUpdateStudentDTO studentToBeAdded = new AddOrUpdateStudentDTO("Megan", "Deo", "Sophmore", 19);
//			
//			// addStudent takes in an AddOrUpdateStudentDTO object as the input argument, and returns a Student Object
//			Student insertedRecord = studentDao.addStudent(studentToBeAdded);
//			System.out.println(insertedRecord);
//			
//			// update Student
//			AddOrUpdateStudentDTO studentToBeUpdated = new AddOrUpdateStudentDTO("Megan", "Deo", "Sophmore", 19);
//			Student updatedStudent = studentDao.updateStudent(2, studentToBeUpdated);
//			System.out.println(updatedStudent);
//			
//			// delete student and delete all students
//			studentDao.deleteStudentById(1);
//			studentDao.deleteAllStudent();
//			
//			/*
//			 * For books class 
//			 */
//			
//			List<com.revature.model.Book> result = bookDao.getAllBooks();
//			System.out.println(result);
//			
//			AddOrUpdateBooksDTO bookToBeUpdated = new AddOrUpdateBooksDTO("1212fsdfghf4323", "Legions", "Rashford");
//			Book updateBooks = bookDao.updateBook(1, bookToBeUpdated);
//			System.out.println(updateBooks);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

	}

}
