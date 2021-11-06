package com.revature.dto;

import java.util.Objects;

public class ExceptionMessage {
	private String message;

	public ExceptionMessage() {

	}

	public ExceptionMessage(Exception e) {
		this.message = e.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionMessage [message=" + message + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionMessage other = (ExceptionMessage) obj;
		return Objects.equals(message, other.message);
	}

}
