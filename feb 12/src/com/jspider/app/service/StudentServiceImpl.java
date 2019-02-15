package com.jspider.app.service;

import com.jspider.app.dao.StudentDaoImpl;
import com.jspider.app.dao.StudentDaoInterface;
import com.jspider.app.dto.StudentDto;

public class StudentServiceImpl implements StudentServiceInterfce {

	StudentDaoInterface studentDao = new StudentDaoImpl();

	@Override
	public int saveStudent(StudentDto student) throws Exception {

		String password = student.getPassword();
		// dummy logic just for test
		String newpassword = password +password;
		student.setPassword(newpassword);
		
		int result = studentDao.saveStudent(student);
		
		return result;
	}

	
	@Override
	public StudentDto fetchStudent(String userName) throws Exception {
		// some logic or no logic 
		 StudentDto  student = studentDao.fetchStudent(userName);
		return student;
	}

	
}
