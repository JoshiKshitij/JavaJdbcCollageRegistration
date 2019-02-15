package com.jspider.app.dto;

public class StudentDto {

	private String firstName;
	private String lastName;
	private String mobileNO;
	private String userName;
	private String password;
	private String email;
	private long rollNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String firstName, String lastName, String mobileNO, String userName, String password,
			String email, long rollNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNO = mobileNO;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "StudentDto [firstName=" + firstName + ", lastName=" + lastName + ", mobileNO=" + mobileNO
				+ ", userName=" + userName + ", password=" + password + ", email=" + email + ", rollNo=" + rollNo + "]";
	}

	public StudentDto(String firstName, String lastName, String mobileNO, String userName, String password,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNO = mobileNO;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.rollNo = rollNo;
	}

}
