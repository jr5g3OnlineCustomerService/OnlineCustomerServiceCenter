package com.cg.onlinecustomerservice.service;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;

public interface ICustomerService {
	public String login(Login login);
	public String registerCustomer(Customer customer);
	public Issue viewIssuesById(int issueid);
	public Issue reopenIssue(int issueid);
	public String changePassword(Login login);
	public String forgotPassword(int id);
	public Customer emailPassword(int id);
}
