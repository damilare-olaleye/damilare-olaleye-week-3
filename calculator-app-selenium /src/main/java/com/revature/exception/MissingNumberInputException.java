package com.revature.exception;

public class MissingNumberInputException extends RuntimeException {

	public MissingNumberInputException() {
		super();
		
	}

	public MissingNumberInputException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	
	}

	public MissingNumberInputException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public MissingNumberInputException(String arg0) {
		super(arg0);
		
	}

	public MissingNumberInputException(Throwable arg0) {
		super(arg0);
		
	} 
	

}
