package com.cg.onlinecustomerservice.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ChatDto {
	private int chatId;
	//@NotNull (message="This field cannot be empty")
	private Date chatDate;
	@NotNull (message="This field cannot be empty")
	private String complaints;
	@NotNull (message="This field cannot be empty")
	private String firstName;
	@NotNull (message="This field cannot be empty")
	private String lastName;
	@NotNull (message="This field cannot be empty")
	private String email;
	@NotNull (message="This field cannot be empty")
	private int customerId;
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public Date getChatDate() {
		return chatDate;
	}
	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}
	
	public String getComplaints() {
		return complaints;
	}
	public void setComplaints(String complaints) {
		this.complaints = complaints;
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
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public ChatDto(int chatId, Date chatDate, String opinion, String firstName, String lastName, String email,int customerId) {
		super();
		this.chatId = chatId;
		this.chatDate = chatDate;
		this.complaints = opinion;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.customerId=customerId;
	}
	public ChatDto() {
		
	}
}
