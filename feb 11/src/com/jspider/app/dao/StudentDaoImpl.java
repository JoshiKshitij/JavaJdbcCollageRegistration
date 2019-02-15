package com.jspider.app.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.jspider.app.dto.StudentDto;

public class StudentDaoImpl implements StudentDaoInterface {

	Properties properties;

	@Override
	public int saveStudent(StudentDto student) throws Exception {

		String driver = (String)properties.get("driver");
		Class.forName(driver);
		
		String url = (String)properties.get("url");
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		Connection connection = DriverManager.getConnection(url, properties);
		
		PreparedStatement prepareStatement = connection
				.prepareStatement("insert into table_students values(?,?,?,?,?,?,?)");
		prepareStatement.setString(1, student.getFirstName());
		prepareStatement.setString(2, student.getLastName());
		prepareStatement.setString(3, student.getMobileNO());
		prepareStatement.setString(4, student.getUserName());
		prepareStatement.setString(5, student.getPassword());
		prepareStatement.setString(6, student.getEmail());
		prepareStatement.setLong(7, student.getRollNo());
		int update = prepareStatement.executeUpdate();
		return update;

	}

	public StudentDto fetchStudent(String userName ) throws Exception{
		
		String driver = (String)properties.get("driver");
		Class.forName(driver);
		
		String url = (String)properties.get("url");
		Connection connection = DriverManager.getConnection(url , properties);
		PreparedStatement prepareStatement = connection
				.prepareStatement("select * from table_students where user_name = ?");
		
		prepareStatement.setString(1, userName);
		ResultSet resultSet = prepareStatement.executeQuery();
		
		//prepareStatement.execute();
		//prepareStatement.getResultSet();
		
		StudentDto student = new StudentDto(); 
		
		if(resultSet.next()) {
			String firstName = resultSet.getString("first_name");
			student.setFirstName(firstName);
			
			String lastName = resultSet.getString("last_name");
			student.setLastName(lastName);
			
			String mobileNo = resultSet.getString("mobile_name");
			student.setMobileNO(firstName);
			
			String userNameFromDb = resultSet.getString("user_name");
			student.setUserName(userNameFromDb);
			
			String password = resultSet.getString("password");
			student.setPassword(firstName);
			
			String email = resultSet.getString("email");
			student.setEmail(firstName);
			
			long rollNo = resultSet.getLong("roll_number");
			student.setRollNo(rollNo);	
		}
		
		return student;
	}
	
	
	public StudentDaoImpl() {
		
		System.out.println("dao object created");

		try {
			// holder for the data from the properties file
			this.properties = new Properties();
			// file will give the location of the properties file in project
			File file = new File("src/com/jspider/app/config/system.properties");
			//stream will create the connection btw the the properties java object
			// and properties file
			InputStream stream = new FileInputStream(file);
			// the load the stream into properties
			this.properties.load(stream);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
