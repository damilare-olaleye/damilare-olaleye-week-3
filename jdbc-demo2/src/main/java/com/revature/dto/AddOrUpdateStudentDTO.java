package com.revature.dto;

public class AddOrUpdateStudentDTO {

	/*
	 * 
	 * DTO (Data Transfer Object): An object that contains properties, getters/setters and possibly an overridden equals + hashcode and toString method
	 * That is used to encapsulate data and pass that data around as this single object
	 * This data will be stored as instance variable/properties of that object
	 * 
	 * Model - Is a type of DTO, but more pecifically, it has all of the properties associated with the database representation
	 * 
	 * For example, the Student class is a model of rows in the students table
	 * 
	 * 
	 */
	
	// This is a DTO used to, in our case, add or update a student in the students table 

	private String firstName;
	private String lastName;
	private String classification;
	private int age;
	
	public AddOrUpdateStudentDTO() {
		
	}
	
	public AddOrUpdateStudentDTO(String firstName, String lastName, String classification, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.classification = classification;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}