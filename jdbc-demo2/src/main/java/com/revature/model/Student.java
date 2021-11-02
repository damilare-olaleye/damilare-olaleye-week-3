package com.revature.model;

import java.util.Objects;

// we will follow the convention of a Java bean
// 1. No-args constructors
// 2. All-args constructors
// 3. All private variables
// 4. getters-setters

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private String classification;
	private int age;

	public Student() {
		// super() is inserted implicitly. What this means is that parent constructors
		// are always called
		// Because Student is not explicitly inheriting any class, it is extending
		// directly the Object class
		// Hence, the implicity super() is invoking the Object class constructor before
		// running the rest of the code
		// inside of this constructor
	}

	public Student(int id, String firstName, String lastName, String classification, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.classification = classification;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getClassfication() {
		return classification;
	}

	public void setClassfication(String classfication) {
		this.classification = classfication;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, classification, firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(classification, other.classification)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", classfication="
				+ classification + ", age=" + age + "]";
	}

}
