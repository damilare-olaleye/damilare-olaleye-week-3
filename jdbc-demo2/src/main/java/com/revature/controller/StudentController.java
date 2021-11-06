package com.revature.controller;

import java.util.List;

import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.dto.ExceptionMessage;
import com.revature.model.Student;
import com.revature.service.StudentService;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.exceptions.InvalidParameterException;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class StudentController {

	// The controller layer will be directly communicating with the service layer,
	// and the Service layer will
	// be directly communicating with the Data access layer.
	// Our dependency here for our Controller

	private StudentService studentService; // StudentController instance HAS-A studentService

	public StudentController() {
		this.studentService = new StudentService();
	}

	private Handler editStudentFirstName = (ctx) -> {

		// Extract the id from the URI path
		String studentId = ctx.pathParam("id");

		// PATCH -> http://localhost:8080/

		// Body -> Raw -> Json

		// Extract the information in the form of JSON from the body and place it into
		// an object of the type EditFirstNameDTO or AddOrUpdateStudentDTO
		AddOrUpdateStudentDTO dto = ctx.bodyAsClass(AddOrUpdateStudentDTO.class); // we need a no-args constructor and
																					// setters

		// When we invoke the editFirstNameOfStudent method (service layer), it will
		// then contact the updateStudent method in the DAO layer, which
		// will then return the Student object representation of the record that was
		// newly updated
		Student studentThatWasJustEdited = this.studentService.editFirstNameOfStudent(studentId, dto.getFirstName());

		// we then take that object and convert it into JSON
		// This JSON is then sent back to the client that sent the request (in our case,
		// Postman)
		ctx.json(studentThatWasJustEdited); // For this to work, we need to have getter method that exist for that
											// object

	};

	private Handler addStudent = (ctx) -> {
		AddOrUpdateStudentDTO dto = ctx.bodyAsClass(AddOrUpdateStudentDTO.class);

		Student s = this.studentService.addStudent(dto);

		ctx.json(s);
		ctx.status(201); // 201 CREATED

	};

	private Handler getAllStudents = (ctx) -> {
		List<Student> student = this.studentService.getAllStudents();

		ctx.json(student);
	};

	private Handler getStudentById = (ctx) -> {
		String id = ctx.pathParam("id");

		Student s = this.studentService.getStudentById(id);
		ctx.json(s);

	};

	private Handler editStudentById = (ctx) -> {
		String id = ctx.pathParam("id");

		Student s = this.studentService.getStudentById(id);
		ctx.json(s);
	};

	private Handler deleteStudentById = (ctx) -> {

		String id = ctx.pathParam("id");

		this.studentService.deleteStudentById(id);

	};

	private Handler deleteAllStudentById = (ctx) -> {
		String id = ctx.pathParam("id");

//		Student s = this.studentService.deleteStudentById(id);
//		ctx.json(s);
	};

	/*
	 * HTTP: HyperText Transfer Protocol
	 * 
	 * 
	 * Widely used protocol for communicating over the Internet.
	 * 
	 * It is composed of requests and responses. A client will send a request to a
	 * server, and the server will send a reponse to the client
	 * 
	 * Example of an HTTP client: Postman, Chrome, Internet Exploere, curl Example
	 * of an HTTP Server: Our Javalin application
	 * 
	 * HTTP Requests: 1. An HTTP method - GET: get a particular resource (ex. GET/
	 * students <- get a list of all students) - POST: add a particular rsource (ex.
	 * POST / students <- add a student) - PUT: fully replace entire resources
	 * (students with id of 1 with an entirely new set of properties) with all the
	 * properties we specify - PATCH: partially replace a resource (ex. PATCH
	 * /students/1/firstname <- replace the firstName of student with id 1 to
	 * somthing else - DELETE: delete a resource (ex. DELETE /students/1 <- delete a
	 * student with id 1)
	 * 
	 * HTTP methods do not implement anyything on their own. It is just part of a
	 * convention that this protocol uses weh dealing with resources. It is up to
	 * the programmer to use the correct convention and implement the functionality
	 * of their HTTP backend to support these operations with different resources.
	 * HTTP methods are often known as HTTP verbs. This naming is made becuase it is
	 * of course, similar to grammar. It is up to the program speaking on whether
	 * they are using the grammar correctly or not.
	 * 
	 * 2. URI (Uniform resource identifier) 3. Request headers 4. Request body
	 * 
	 * Ex. PATCH /students/7/firstname - Request body: {"firstName" : "skdfsdfad"}
	 * 
	 * The server will receive the request, and then provide an HTTP Response
	 * 
	 * HTTP Responses: 1. Status Code: 2XX means OK, 4XX client error, 5XX Server
	 * sided error (usually means you didn't catch an exception and then provide a
	 * more specific response status code)
	 * https://cheatography.com/kstep/cheat-sheets/http-status-codes/ 2. Response
	 * Header 3. Response Body Ex => {"id": 1. "firstName": "Dammy", "lastName":
	 * "Doe", "Classification": "Freshman", "age": 18}
	 * 
	 */

	public void registerEndpoints(Javalin app) {
		app.patch("/students/{id}/firstname", editStudentFirstName);

		app.post("/students", addStudent);
		app.get("/students", getAllStudents);
		app.get("/students/{id}", getStudentById);
		app.put("/students/{id}", editStudentById);
		app.delete("/students/{id}", deleteStudentById);
		app.delete("/students", deleteAllStudentById);
	}
}
