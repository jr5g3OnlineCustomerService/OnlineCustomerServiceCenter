package com.cg.onlinecustomerservice.entity;
import java.util.Date;
<<<<<<< HEAD

import javax.persistence.CascadeType;
=======
>>>>>>> branch 'master' of https://github.com/jr5g3OnlineCustomerService/OnlineCustomerServiceCenter.git
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="call")
public class Call {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
@Column(name="callId")
private int callId;

=======
@Column(name="callid")
private int callid;
>>>>>>> branch 'master' of https://github.com/jr5g3OnlineCustomerService/OnlineCustomerServiceCenter.git
@Column
private Date callDate;
@Column
private double callDuration;
@Column
private String phoneNumber;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "operatorId", referencedColumnName = "operatorId")
private Operator operator;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "customerId", referencedColumnName = "customerId")
private Customer customer;

public Call()
{
	
}
public Call(int callid, Date callDate, double callDuration, String phoneNumber) {
	super();
	this.callId = callid;
	this.callDate = callDate;
	this.callDuration = callDuration;
	this.phoneNumber = phoneNumber;
}
public int getCallid() {
	return callId;
}
public void setCallid(int callid) {
	this.callId = callid;
}
public Date getCallDate() {
	return callDate;
}
public void setCallDate(Date callDate) {
	this.callDate = callDate;
}
public double getCallDuration() {
	return callDuration;
}
public void setCallDuration(double callDuration) {
	this.callDuration = callDuration;
}
public String getPhoneNumber(){
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
}
