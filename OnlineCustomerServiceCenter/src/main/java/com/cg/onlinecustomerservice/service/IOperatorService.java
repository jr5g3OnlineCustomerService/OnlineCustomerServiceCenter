package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;

public interface IOperatorService {
	public String login(Login login);
	public Issue modifyCustomerIssue(Issue issue);
	public Issue addCustomerIssue(IssueDto issueDto);
	public Issue closeCustomerIssue(Issue issue);
	public Customer findCustomerById(int id);
	public List<Customer> findCustomerByName(String name);
	public Customer findCustomerByEmail(String email);
	public boolean lockCustomer(int id);
	public Solution addSolution(SolutionDto solutiondto);
}
