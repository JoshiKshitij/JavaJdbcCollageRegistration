package com.jspider.app.inputOutput;

import java.util.Scanner;

import com.jspider.app.dto.StudentDto;

public class StudentOutput {

	public StudentDto createStudent(){
		Scanner scanner = new Scanner(System.in);
		StudentDto student = new StudentDto();
		
		System.out.println("enter first Name");
		String firstName = scanner.nextLine();
		student.setFirstName(firstName);
		
		System.out.println("enter last Name");
		String lastName = scanner.nextLine();
		student.setLastName(lastName);
		
		System.out.println("enter MobileNO");
		String mobileNO = scanner.nextLine();
		student.setMobileNO(mobileNO);
		
		System.out.println("enter Email");
		String email = scanner.nextLine();
		student.setEmail(email);
		
		System.out.println("enter UserName");
		String userName = scanner.nextLine();
		student.setUserName(userName);
		
		System.out.println("enter Password");
		String password = scanner.nextLine();
		student.setPassword(password);		
		
		//important
		System.out.println("Enter the roll no");
		long rollNo = scanner.nextLong();
		student.setRollNo(rollNo);
		
		scanner.close();
		return student;
	}
	
	
}
