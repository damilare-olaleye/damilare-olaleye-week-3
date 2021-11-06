package com.revature.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.dao.StudentDao;
import com.revature.dto.AddOrUpdateStudentDTO;
import com.revature.dto.EditFirstNameDTO;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.StudentNotFoundException;
import com.revature.model.Student;

public class StudentServiceTest {

	/*
	 * AAA
	 * 
	 * A - Arrange A - Add A - Assert
	 */

	/*
	 * ARRANGE
	 */

	// Define the System under test: StudentService
	private StudentService studentService;

	/*
	 * StudentService's getAllStudent() tests
	 * 
	 */

	// Positive test (happy test)
	@Test
	public void testGetAllStudentPositive() throws SQLException {
		// StudentService requires a StudentDao object property
		// So, let's go ahead and mock a StudentDao object
		StudentDao mockStudentDao = mock(StudentDao.class); // this is a fake object, becuase we are not using a "new
															// constructor ()" we are using mock from Mokito
		// That creates a fake object that we can specify scenrios for whenever we call
		// that object's instance methods

		Student student1 = new Student(10, "Bob", "Jones", "Senior", 22);
		Student student2 = new Student(10, "John", "Doe", "Freshman", 18);
		Student student3 = new Student(15, "Jane", "Jones", "Sophmore", 19);

		List<Student> studentsFromDao = new ArrayList<>();
		studentsFromDao.add(student1);
		studentsFromDao.add(student2);
		studentsFromDao.add(student3);

		when(mockStudentDao.getAllStudents()).thenReturn(studentsFromDao);

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT
		 */

		List<Student> actual = studentService.getAllStudents();

		/*
		 * ASSERT
		 */
		List<Student> expected = new ArrayList<>();
		expected.add(new Student(10, "Bob", "Jones", "Senior", 22));
		expected.add(new Student(10, "John", "Doe", "Freshman", 18));
		expected.add(new Student(15, "Jane", "Jones", "Sophmore", 19));

		Assertions.assertEquals(expected, actual);
	}

	// Negative Test
	@Test
	public void testGetAllStudentisSQLExceptionOccurs() throws SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao mockStudentDao = mock(StudentDao.class);

		when(mockStudentDao.getAllStudents()).thenThrow(SQLException.class);

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT
		 */

		// Our test will pass, if the code inside the second argument's lambda
		// expression throws a SQLException
		Assertions.assertThrows(SQLException.class, () -> {

			studentService.getAllStudents();
		});
	}

	/*
	 * 
	 * Student's services getStudentById(Int id)
	 */

	// Positive test (happy path)
	@Test
	public void testGetStudentByIdPositive() throws SQLException, InvalidParameterException, StudentNotFoundException {
		/*
		 * ARRANGE
		 */
		StudentDao mockStudentDao = mock(StudentDao.class);

		when(mockStudentDao.getStudentById(5)).thenReturn(new Student(5, "Damilare", "Olaleye", "Senior", 23));

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT
		 */
		Student actual = studentService.getStudentById("5");

		/*
		 * ASSERT
		 */

		Assertions.assertEquals(new Student(5, "Damilare", "Olaleye", "Senior", 23), actual);

	}

	// Negative TEst
	// StudentNotFoundException is thrown
	@Test
	public void testGetStudentsByIdNotFoundNegative()
			throws SQLException, StudentNotFoundException, InvalidParameterException {
		/*
		 * ARRANGE
		 */
		StudentDao mockStudents = mock(StudentDao.class);

		StudentService studentService = new StudentService(mockStudents);

		/*
		 * ACT AND ASSERT
		 * 
		 */
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.getStudentById("1");
		});

	}

	// Negative Test
	// InvalidParametherException is thrown
	@Test
	public void testGetStudentByIdAlphabeticalIdNegative() {

		/*
		 * ARRANGE
		 */

		StudentDao mockStudentDao = mock(StudentDao.class);

		// By default, any object returned from one of the methods called from the mock
		// student dao will return null
		// So here we are not specifying any when(...).thenReturn(...);

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT AND ASSERT
		 */

		Assertions.assertThrows(InvalidParameterException.class, () -> {
			studentService.getStudentById("adc"); // ACT
		});
	}

	// Negative Test
	// InvalidParametherException is thrown
	@Test
	public void testGetStudentByIdDecimalIdNegative() {

		/*
		 * ARRANGE
		 */

		StudentDao mockStudentDao = mock(StudentDao.class);

		// By default, any object returned from one of the methods called from the mock
		// student dao will return null
		// So here we are not specifying any when(...).thenReturn(...);

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT AND ASSERT
		 */

		Assertions.assertThrows(InvalidParameterException.class, () -> {
			studentService.getStudentById("1.0"); // ACT
		});
	}

	// Positive (happy path)
	@Test
	public void testEditFirstNameOfStudentPositive()
			throws SQLException, StudentNotFoundException, InvalidParameterException {

		/*
		 * ARRANGE
		 */
		StudentDao mockStudentDao = mock(StudentDao.class);

		when(mockStudentDao.getStudentById(eq(5))).thenReturn(new Student(5, "Jane", "Doe", "Freshman", 18));

		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Ashley", "Doe", "Freshman", 18);

		when(mockStudentDao.updateStudent(eq(5), eq(dto))).thenReturn(new Student(5, "Ashley", "Doe", "Freshman", 18));

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT
		 */

		
		Student actual = studentService.editFirstNameOfStudent("5", "Ashley");

		/*
		 * ASSERT
		 */
		
		Student expected = new Student(5, "Ashley", "Doe", "Freshman", 18); // we expect the firstName property to be
																			// Ashley at this point

		Assertions.assertEquals(expected, actual);

	}
	

	// Negative
	// StudentNotFoundException case
	@Test
	public void testEditFirstNameOfStudentButStudentWithId10DoesNotExist() {
		/*
		 * ARRANGE
		 * 
		 */
		StudentDao mockStudentDao = mock(StudentDao.class);

		// mocked methods that returns object will return null by default
		// so we don't need to worry about when(...).thenReturn(null)

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT and ASSERT
		 */

		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentService.editFirstNameOfStudent("10", "Bill"); // ACT
		});
	}

	// Negative
	// InvalidParameterException thrown
	@Test
	public void testEditFirstNameButIdProvidedIsNotAnInt() {
		/*
		 * ARRANGE
		 * 
		 */
		StudentDao mockStudentDao = mock(StudentDao.class);

		// mocked methods that returns object will return null by default
		// so we don't need to worry about when(...).thenReturn(null)

		StudentService studentService = new StudentService(mockStudentDao);

		/*
		 * ACT and ASSERT
		 */

		Assertions.assertThrows(InvalidParameterException.class, () -> {
			studentService.editFirstNameOfStudent("asdf1sdfadsf0", "Bill"); // ACT
		});
	}

	/*
	 * StudentServices's addStudent(AddOrUpdateStudentDto dto) method
	 * 
	 */

	// Positive (happy path)
	@Test
	public void testAddStudentAllInformationCorrectInDTO() throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		AddOrUpdateStudentDTO dtoIntoDao = new AddOrUpdateStudentDTO("Billy", "Tran", "Freshman", 5);

		when(studentDao.addStudent(eq(dtoIntoDao))).thenReturn(new Student(100, "Billy", "Tran", "Freshman", 5));

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Billy", "Tran", "Freshman", 5);
		Student actual = studentService.addStudent(dto);

		/*
		 * ASSERT
		 */
		Student expected = new Student(100, "Billy", "Tran", "Freshman", 5);
		Assertions.assertEquals(expected, actual);

	}

	// Negative
	// Scenario: everything is correct except the firstName was left blank
	@Test
	public void testAddStudentFirstNameBlankEverythingElseValid() throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT and ASSERT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("      ", "Tran", "Freshman", 5);

		Assertions.assertThrows(InvalidParameterException.class, () -> {

			studentService.addStudent(dto);

		});

	}

	// Negative
	// Scenario: everything is correct except the lastName was left blank
	@Test
	public void testAddStudentLastNameBlankEverythingElseValid() throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT and ASSERT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Billy", "                 ", "Freshman", 5);

		Assertions.assertThrows(InvalidParameterException.class, () -> {

			studentService.addStudent(dto);

		});

	}

	// Negative
	// Scenario: everything is correct except both the firstName and lastName were
	// left blank
	@Test
	public void testAddStudentFirstNameAndLastNameBlankEverythingElseValid()
			throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT and ASSERT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("", "                 ", "Freshman", 5);

		Assertions.assertThrows(InvalidParameterException.class, () -> {

			studentService.addStudent(dto);

		});

	}

	// Negative
	// Scenario: everything is correct except classification was invalidly spelled
	@Test
	public void testAddStudentFreshmanSpelledIncorrectlyEverythingElseValid()
			throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT and ASSERT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Billy", "    Tran             ", "Freshmon", 5);

		Assertions.assertThrows(InvalidParameterException.class, () -> {

			studentService.addStudent(dto);

		});

	}

	// Negative
	// Scenario: everything is correct except age is negative
	@Test
	public void testAddStudentAgeIsNegativeEverythingElseValid() throws InvalidParameterException, SQLException {
		/*
		 * ARRANGE
		 */
		StudentDao studentDao = mock(StudentDao.class);

		StudentService studentService = new StudentService(studentDao);

		/*
		 * ACT and ASSERT
		 */
		AddOrUpdateStudentDTO dto = new AddOrUpdateStudentDTO("Billy", "    Tran             ", "Freshman", -100);

		Assertions.assertThrows(InvalidParameterException.class, () -> {

			studentService.addStudent(dto);

		});

	}

}