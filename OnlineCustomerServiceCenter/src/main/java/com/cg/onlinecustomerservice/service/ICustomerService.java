package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.dto.ChatDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.InvalidCredentialException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.SolutionNotFoundException;

public interface ICustomerService {
	public Customer customerLogin(Customer customer);//
	public String registerCustomer(Customer customer);
	public Issue viewIssuesById(int issueid);
	public List<Issue> ViewAllIssues();
	//public String changePassword(Login login);
	//List<Customer> ViewAllCustomers() ;
	Issue reOpenIssue(int id) ;
	List<Solution> ViewAllSolutions();
	Solution viewSolutionsById(int code) ;	
	public String addChat(ChatDto chatDto);
	public String changePassword(Customer customer);
}
