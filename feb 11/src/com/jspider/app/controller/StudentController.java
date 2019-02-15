package com.jspider.app.controller;


import com.jspider.app.dto.StudentDto;
import com.jspider.app.inputOutput.StudentOutput;
import com.jspider.app.service.StudentServiceImpl;
import com.jspider.app.service.StudentServiceInterfce;

public class StudentController {

	static StudentServiceInterfce serivce = new StudentServiceImpl();
	
	public static void main(String[] args)  {
		
		StudentOutput output = new StudentOutput();
		StudentDto student =output.createStudent();
		System.out.println(student);
				
		int outcome = 0;
		try {
			 outcome = serivce.saveStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("no of rows affected are " + outcome);
	}
	
	
}
