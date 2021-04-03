package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;


@Service
public class CustomerService {
	@Autowired
	LoginDao loginDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	IssueDao issueDao;
	public String login(Login l)
	{
		if(loginDao.existsById(l.getUsername()))
			return "Login successful";
		else
			return "User doesnt exist";
		}
	
	public String registerCustomer(Customer customer)
	{
		Customer cust= customerDao.save(customer);
		if(cust!=null)
		return "Customer inserted";
		else{
			return "Could not Insert";
		}
	}
	
	
	public Issue viewIssuesById(int issueid)
	{
		return issueDao.getIssueById(issueid);
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
