package com.revature.demo;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.StudentDao;
import com.revature.model.Student;

public class Applicaton {

	public static void main(String[] args) {

		StudentDao studentDao = new StudentDao();
		
		try {
			List<Student> results = studentDao.getAllStudents();
			System.out.println(results);
			
			Student s = studentDao.getStudentById(1);
			System.out.println(s);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
