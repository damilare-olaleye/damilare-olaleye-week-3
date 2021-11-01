package com.revature.service;

import com.revature.exception.MissingNumberInputException;

public class ArithmeticService {
	
	public void checkInput(String leftInput, String rightInput) {
		
		if(leftInput.trim().equals("") && rightInput.trim().equals("")) {
			throw new MissingNumberInputException("Both inputs are missing");
		}
		if(leftInput.trim().equals("")) {
			throw new MissingNumberInputException("Left inputs missing");
		}
		if(rightInput.trim().equals("")) {
			throw new MissingNumberInputException("Right inputs missing");
		}
	}

	public String doAddition(String firstNumberString, String secondNumberString) {

		checkInput(firstNumberString, secondNumberString);
		
		double firstNumber = Double.parseDouble(firstNumberString);
		double secondNumber = Double.parseDouble(secondNumberString);
		double sum = firstNumber + secondNumber;

		String result = "" + sum;

		return result;
	}

	public String doSubtract(String firstNumberString, String secondNumberString) {
		checkInput(firstNumberString, secondNumberString);
		
		double firstNumber = Double.parseDouble(firstNumberString);
		double secondNumber = Double.parseDouble(secondNumberString);
		double subtract = firstNumber - secondNumber;

		String result = "" + subtract;

		return result;
	}

	public String doDivide(String firstNumberString, String secondNumberString) {
		checkInput(firstNumberString, secondNumberString);
		
		double firstNumber = Double.parseDouble(firstNumberString);
		double secondNumber = Double.parseDouble(secondNumberString);
		double divide = firstNumber / secondNumber;

		String result = "" + divide;

		return result;
	}

	public String doMultiply(String firstNumberString, String secondNumberString) {
		checkInput(firstNumberString, secondNumberString);
		
		double firstNumber = Double.parseDouble(firstNumberString);
		double secondNumber = Double.parseDouble(secondNumberString);
		double multiply = firstNumber * secondNumber;

		String result = "" + multiply;

		return result;
	}

	public String doMod(String firstNumberString, String secondNumberString) {
		checkInput(firstNumberString, secondNumberString);
		
		double firstNumber = Double.parseDouble(firstNumberString);
		double secondNumber = Double.parseDouble(secondNumberString);
		double mod = firstNumber % secondNumber;

		String result = "" + mod;

		return result;
	}

}
