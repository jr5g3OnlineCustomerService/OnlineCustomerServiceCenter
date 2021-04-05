package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;

public interface IOperatorService {
	public String login(Login login);
	public Issue modifyCustomerIssue(Issue issue);
	public String sendModificationEmailToCustomer(int a,int b);
	public Issue closeCustomerIssue(Issue issue);
	public Customer findCustomerById(int id);
	public List<Customer> findCustomerByName(String name);
	public Customer findCustomerByEmail(String email);
	public boolean lockCustomer(int id);
	String sendIntimationEmailToCustomer(int a, int b);
	
	
}
