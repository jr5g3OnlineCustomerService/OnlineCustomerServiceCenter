package com.cg.onlinecustomerservice.entity;
import java.util.Date;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="chat")
public class Chat {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="chatId")
private int chatId;

@Column
private Date chatDate;
@Column
private String complaints;
@Column
private String firstName;
@Column
private String lastName;
@Column
private String email;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "customerId", referencedColumnName = "customerId")
private Customer customer;
public Chat(int chatId, Date chatDate, String complaints, String firstName, String lastName, String email) {
	super();
	this.chatId = chatId;
	this.chatDate = chatDate;
	this.complaints = complaints;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	
}
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
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}


}