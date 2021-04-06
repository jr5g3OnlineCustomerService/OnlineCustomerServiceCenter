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


@Service
public class CustomerService implements ICustomerService{
	@Autowired
	LoginDao loginDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	IssueDao issueDao;
  public String login(Login l)
	{
		if(loginDao.existsById(l.getUserId()))
			return "Login successful";
		else
			return "User doesnt exist";
		}
	@Override
	public String registerCustomer(Customer customer)
	{
		Customer cust= customerDao.save(customer);
		if(cust!=null)
			return "Customer inserted";
		else{
			return "Could not Insert";
		}
	}
	
	@Override
	public Issue viewIssuesById(int issueid)
	{
		return issueDao.getIssueById(issueid);
	}
	
	@Override
	public String changePassword(Login login)
	{	
		int id=0;
		id=login.getUserId();
		if(id!=0) {
			Login log=loginDao.findById(id).get();
			log.setPassword(login.getPassword());
			loginDao.save(log);
			return "Email updated";
		}
		else {
			return "User not found";
		}
	}
	@Override
	public List<Issue> ViewAllIssues() {
		List<Issue> response=issueDao.findAll();
		return response;
	}
	@Override
	public List<Customer> ViewAllCustomers() {
		List<Customer>response=customerDao.findAll();
		return response;
	}
}
