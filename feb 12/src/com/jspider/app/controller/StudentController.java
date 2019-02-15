package com.jspider.app.controller;


import java.util.Scanner;

import com.jspider.app.dto.StudentDto;
import com.jspider.app.inputOutput.StudentOutput;
import com.jspider.app.service.StudentServiceImpl;
import com.jspider.app.service.StudentServiceInterfce;

public class StudentController {

	static StudentServiceInterfce serivce = new StudentServiceImpl();
	
	public static void main(String[] args)  {
		
		/*
		 * StudentOutput output = new StudentOutput(); StudentDto student
		 * =output.createStudent(); System.out.println(student);
		 */
		/*
		 * int outcome = 0; try { outcome = serivce.saveStudent(student); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		//System.out.println("no of rows affected are " + outcome);
	
		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter the user name");
			String userName = scanner.nextLine();
			
			System.out.println("enter the pass word ");
			String password = scanner.nextLine();
			
			// after fecthing the student fom the db
			StudentDto student = serivce.fetchStudent(userName);
			System.out.println(student);
			
			
			if(student != null && student.getPassword().equals( password) ) {
				System.out.println("welcome " +student.getFirstName() +" "+ student.getLastName());
			}
			else {
				System.out.println("wrong user name or password");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
