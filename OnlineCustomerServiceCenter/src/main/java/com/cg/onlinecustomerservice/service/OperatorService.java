package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Operator;

@Service
public class OperatorService {
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
public Issue addCustomerIssue(Issue issue)
{
	return issueDao.save(issue);
}
public Issue closeCustomerIssue(Issue issue)
{
	int id=issue.getIssueId();
	Issue result=issueDao.getIssueById(id);
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}
public Issue modifyCustomerIssue(Issue issue) {
	int id=issue.getIssueId();
	Issue result=issueDao.findById(id).get();
	result.setDescription(issue.getDescription());
	result.setIssueType(issue.getIssueType());
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}
public Customer findCustomerById(int id)
{
	return customerDao.findCustomerById(id);
	
}
public List<Customer> findCustomerByName(String name)
{
	return customerDao.findCustomerByName(name);
}
public Customer findCustomerByEmail(String email)
{
	return customerDao.findCustomerByEmail(email);
}
public boolean lockCustomer(int id) {
		
}
}
