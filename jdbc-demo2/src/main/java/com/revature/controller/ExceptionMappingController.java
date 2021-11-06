package com.revature.controller;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.revature.dto.ExceptionMessage;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.StudentNotFoundException;

import io.javalin.Javalin;

// when we have exceptions that propagate all the way to way our Handlers in the controller layer, we can instead of using try {} catch () {}
// utilize Jvalin's exception mapping functionality
// This allows us to map exceptions that may make it's way to the controller layer, and then handle them within a centralized location
// This prevents code redundancy and duplication

public class ExceptionMappingController {

	public void mapExceptions(Javalin app) {
		
		app.exception(UnrecognizedPropertyException.class, (e,ctx) -> {
			ctx.json(new ExceptionMessage(e));
			ctx.status(400);
		
		});
		
		app.exception(InvalidParameterException.class, (e, ctx) -> {
			ctx.json(new ExceptionMessage(e));
			ctx.status(400);
		});
		
		
		// For example, in the cases where we want to modify or delete or get a student who does not exist (PUT /students/1000, 
		// GET /students/10000), that should result in some kind of StudentNotFoundException being thrown in the service layer.
		// When it propagates to the controller layer, that is when we can go ahead and specify a 404 Not found HTTP status code (and an appropriate exception message
		app.exception(StudentNotFoundException.class, (e, ctx) -> {
			ctx.json(new ExceptionMessage(e));
			ctx.status(400);
		});
		
	}
}
