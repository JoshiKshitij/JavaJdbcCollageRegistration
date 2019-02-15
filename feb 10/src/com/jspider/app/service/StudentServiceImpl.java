package com.jspider.app.service;

import com.jspider.app.dao.StudentDaoImpl;
import com.jspider.app.dao.StudentDaoInterface;
import com.jspider.app.dto.StudentDto;

public class StudentServiceImpl implements StudentServiceInterfce {

	StudentDaoInterface studentDao = new StudentDaoImpl();

	@Override
	public int saveStudent(StudentDto student) throws Exception {

		//System.out.println("step 2");
		//System.out.println("student recived in serivce");
		/*
				1. encode the passwrod 
		*/
		String password = student.getPassword();
		String newpassword = password +password;
		student.setPassword(newpassword);
		
		int result = studentDao.saveStudent(student);
		
		
//		System.out.println("Step 5 ");
	//	System.out.println("resut send to controller");
		return result;
	}

}
