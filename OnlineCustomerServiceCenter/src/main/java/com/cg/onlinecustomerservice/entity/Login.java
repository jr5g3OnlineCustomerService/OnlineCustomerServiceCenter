package com.cg.onlinecustomerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="username")
	private int username;
	
	@Column
	private String password;

	@Column
	private UserType type;
	
	@Column
	private boolean isActive;

	public Login(int username, String password, UserType type, boolean isActive) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.isActive = isActive;
	}
	
	public Login() {}

	public int getUsername() {
		return username;
	}

	public void setUsername(int username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
	
	