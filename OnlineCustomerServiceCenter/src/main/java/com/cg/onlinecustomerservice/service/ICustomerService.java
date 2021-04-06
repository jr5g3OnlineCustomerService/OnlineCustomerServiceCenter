package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;

public interface ICustomerService {
	public String login(Login login);
	public String registerCustomer(Customer customer);
	public Issue viewIssuesById(int issueid);
	public List<Issue> ViewAllIssues();
	public String changePassword(Login login);
	List<Customer> ViewAllCustomers();
	Issue reOpenIssue(int id);
	
}
