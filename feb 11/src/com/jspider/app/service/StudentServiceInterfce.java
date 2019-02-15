package com.jspider.app.service;

import com.jspider.app.dto.StudentDto;

public interface StudentServiceInterfce {
	
	
	
	public int saveStudent(StudentDto dto) throws Exception;
	public StudentDto fetchStudent(String userName ) throws Exception;
	
}
