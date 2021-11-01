package com.revature.controller;

import com.revature.exception.MissingNumberInputException;
import com.revature.service.ArithmeticService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ArithmeticController {

	public ArithmeticService arithmeticService;

	// Our constructor
	public ArithmeticController() {
		this.arithmeticService = new ArithmeticService();
	}

	public Handler add = (athc) -> {
		String firstNumberString = athc.formParam("firstNumber");
		String secondNumberString = athc.formParam("secondNumber");

		try {
			athc.result(arithmeticService.doAddition(firstNumberString, secondNumberString));
		} catch(MissingNumberInputException e){
			athc.result(e.getMessage());
		}
		
	};

	public Handler subtract = (athc) -> {
		String firstNumberString = athc.formParam("firstNumber");
		String secondNumberString = athc.formParam("secondNumber");

		try {
			athc.result(arithmeticService.doSubtract(firstNumberString, secondNumberString));
		} catch(MissingNumberInputException e){
			athc.result(e.getMessage());
		}
	};

	public Handler divide = (athc) -> {
		String firstNumberString = athc.formParam("firstNumber");
		String secondNumberString = athc.formParam("secondNumber");

		try {
			athc.result(arithmeticService.doDivide(firstNumberString, secondNumberString));
		} catch(MissingNumberInputException e){
			athc.result(e.getMessage());
		}
		
	};

	public Handler multiply = (athc) -> {
		String firstNumberString = athc.formParam("firstNumber");
		String secondNumberString = athc.formParam("secondNumber");

		try {
			athc.result(arithmeticService.doMultiply(firstNumberString, secondNumberString));
		} catch(MissingNumberInputException e){
			athc.result(e.getMessage());
		}
	};

	public Handler mod = (athc) -> {
		String firstNumberString = athc.formParam("firstNumber");
		String secondNumberString = athc.formParam("secondNumber");
		
		try {
			athc.result(arithmeticService.doMod(firstNumberString, secondNumberString));
		}catch(MissingNumberInputException e){
			athc.result(e.getMessage());
		}
		
	};

	public void registerEndPoint(Javalin app) {
		app.post("/add", add);
		app.post("/subtract", subtract);
		app.post("/divide", divide);
		app.post("/multiply", multiply);
		app.post("/mod", mod);
	}
}
