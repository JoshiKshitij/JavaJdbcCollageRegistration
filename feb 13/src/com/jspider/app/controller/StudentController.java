package com.jspider.app.controller;

import java.util.Scanner;

import com.jspider.app.dto.StudentDto;
import com.jspider.app.inputOutput.StudentOutput;
import com.jspider.app.service.StudentServiceImpl;
import com.jspider.app.service.StudentServiceInterfce;

public class StudentController {

	static StudentServiceInterfce serivce = new StudentServiceImpl();

	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("choose 1 for login");
		System.out.println("choose 2 for delete");
		System.out.println("choose 3 for update");
		System.out.println("choose 4 for register");
	    String method = scanner.next();
	
		switch (method) {
		case "1" :
			System.out.println("login metho called  'service.fetchStudent()'");
			
			break;

		case "2" :
			System.out.println("delete metho called  'service.deleteStudent()'");
			break;
			
		case "3" :
			System.out.println("login metho called  'service.updateStudent()'");
			break;
			
		case "4" :
			System.out.println("resgister metho called  'service.saveStudent()'");
			break;
		
		default:
			System.out.println("defult method");
			break;
		}
	}
}
