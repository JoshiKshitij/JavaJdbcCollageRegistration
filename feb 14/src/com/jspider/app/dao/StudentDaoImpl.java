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
		
		StudentDto student = null;
		
		if(resultSet.next()) {
			
			student = new StudentDto(); 
			String firstName = resultSet.getString("first_name");
			//firstName  = firstName ==null ? "": firstName;
			student.setFirstName(firstName ==null ? "": firstName);
			
			String lastName = resultSet.getString("last_name");
			lastName  = lastName ==null ? "": lastName;
			student.setLastName(lastName);
			
			String mobileNo = resultSet.getString("mobile_number");
			mobileNo  = mobileNo ==null ? "": mobileNo;
			student.setMobileNO(mobileNo);
			
			String userNameFromDb = resultSet.getString("user_name");
			userNameFromDb  = userNameFromDb ==null ? "": userNameFromDb;
			student.setUserName(userNameFromDb);
			
			String password = resultSet.getString("password");
			password  = password ==null ? "": password;
			student.setPassword(password);
			
			String email = resultSet.getString("email");
			email  = email ==null ? "": email;
			student.setEmail(email);
			
			long rollNo = resultSet.getLong("roll_number");
		//	rollNo  = rollNo == 0 ? 0 : rollNo;
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

	@Override
	public int deleteStudent(long rollNO) throws Exception {
		
		String driver = (String)properties.get("driver");
		Class.forName(driver);
		
		String url = (String)properties.get("url");
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage_db", "root", "root");
		Connection connection = DriverManager.getConnection(url, properties);
		
		PreparedStatement prepareStatement = connection
				.prepareStatement("delete from table_students where roll_number =? ");
		
		prepareStatement.setLong(1,rollNO);
		int update = prepareStatement.executeUpdate();
		return update;
		
	}
}
