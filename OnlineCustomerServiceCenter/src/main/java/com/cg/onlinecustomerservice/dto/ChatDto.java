package com.cg.onlinecustomerservice.dto;

import java.util.Date;

public class ChatDto {
	private int chatId;
	private Date chatDate;
	private String opinion;
	private String firstName;
	private String lastName;
	private String email;
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
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
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
	public ChatDto(int chatId, Date chatDate, String opinion, String firstName, String lastName, String email) {
		super();
		this.chatId = chatId;
		this.chatDate = chatDate;
		this.opinion = opinion;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public ChatDto() {
		
	}
}
