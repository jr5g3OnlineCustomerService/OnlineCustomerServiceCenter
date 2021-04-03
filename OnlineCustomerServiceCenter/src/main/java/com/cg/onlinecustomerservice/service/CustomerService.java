package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;


@Service
public class CustomerService {
	@Autowired
	LoginDao login;
	public String login(Login l)
	{
		
		return null;
	}
	public String registerCustomer(Customer customer)
	{
		return null;
	}
	public int viewIssuesById(int issueid)
	{
		return 0;
	}
	public int reopenIssue(int issueid)
	{
		return 0;
	}
	public String changePassword(Login l)
	{
		return null;
	}
}
