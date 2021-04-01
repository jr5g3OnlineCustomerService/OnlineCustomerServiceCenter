package com.cg.onlinecustomerservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="call")
public class Call {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="callid")
private int callid;

@Column
private Date callDate;

@Column
private double callDuration;

@Column
private String phoneNumber;

public int getCallid() {
	return callid;
}

public void setCallid(int callid) {
	this.callid = callid;
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
