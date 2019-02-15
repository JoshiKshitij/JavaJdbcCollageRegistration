package com.jspider.app.controller;

import java.util.Scanner;

import com.jspider.app.dto.StudentDto;
import com.jspider.app.inputOutput.StudentOutput;
import com.jspider.app.service.StudentServiceImpl;
import com.jspider.app.service.StudentServiceInterfce;

public class StudentController {

	static StudentServiceInterfce serivce = new StudentServiceImpl();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("choose 1 for login");
		System.out.println("choose 2 for delete");
		System.out.println("choose 3 for update");
		System.out.println("choose 4 for register");
		String method = scanner.next();
		boolean flag = true;

		while (flag) {
			if (method.equals("1") || method.equals("2") || method.equals("3") || method.equals("4")) {
				flag = false;
				break;
			}
			System.out.println("please the enter the value again wrong input ");
			scanner.nextLine();
			method = scanner.next();
		}

		switch (method) {
		case "1":
			
			System.out.println("login metho called  'service.fetchStudent()'");
			String userName = scanner.next();
			try {
				StudentDto studentFromDb = serivce.fetchStudent(userName);
				System.out.println(studentFromDb);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		
		case "2":
				
			System.out.println("delete metho called  'service.deleteStudent()'");
			long rollNo = scanner.nextLong();
			try {
				int i = serivce.deleteStudent(rollNo);
				System.out.println("rows deleted are " + i);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
			
		case "3":
			System.out.println("update metho called  'service.updateStudent()'");
			break;
		case "4":
			
			System.out.println("resgister metho called  'service.saveStudent()'");
			StudentDto studentFromOut = StudentOutput.createStudent();
			try {
				int i = serivce.saveStudent(studentFromOut);
				System.out.println("no of rows affected " + i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
	}
}
