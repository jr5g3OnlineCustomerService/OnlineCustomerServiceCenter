package com.cg.onlinecustomerservice.dto;

import javax.validation.constraints.NotNull;

public class OperatorDto {
	private int operatorId;
	@NotNull(message="This cannot be empty")
	private String firstName;
	@NotNull(message="This cannot be empty")
	private String lastName;
	@NotNull(message="This cannot be empty")
	private String email;
	@NotNull(message="This cannot be empty")
	private String mobile;
	@NotNull(message="This cannot be empty")
	private String city;
	@NotNull(message="This cannot be empty")
	private String password;
	@NotNull(message="This cannot be empty")
	private int departmentID;
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public OperatorDto(int operatorId, String firstName, String lastName, String email, String mobile, String city,
			int departmentID,String password) {
		super();
		this.operatorId = operatorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.departmentID = departmentID;
		this.password=password;
	}
	public OperatorDto(){}
}
