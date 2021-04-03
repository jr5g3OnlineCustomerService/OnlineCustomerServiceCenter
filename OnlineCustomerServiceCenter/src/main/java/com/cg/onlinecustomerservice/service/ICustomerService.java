package com.cg.onlinecustomerservice.service;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;

public interface ICustomerService {
	public String login(Login login);
	public String registerCustomer(Customer customer);
	public Issue viewIssuesById(int issueid);
	public int reopenIssue(int issueid);
	public String changePassword(Login login);
}
