package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.SolutionNotFoundException;

public interface ICustomerService {
	public String login(Login login);
	public String registerCustomer(Customer customer);
	public Issue viewIssuesById(int issueid) throws IssueNotFoundException;
	public List<Issue> ViewAllIssues() throws IssueNotFoundException;
	public String changePassword(Login login);
	List<Customer> ViewAllCustomers() throws CustomerNotFoundException;
	Issue reOpenIssue(int id) throws IssueNotFoundException;
	List<Solution> ViewAllSolutions() throws SolutionNotFoundException;
	Solution viewSolutionsById(int code) throws SolutionNotFoundException;	
}
