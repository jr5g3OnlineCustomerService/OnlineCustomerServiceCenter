package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.entity.Solution;


public interface IOperatorService {
	public Operator operatorlogin(Operator operator);
	public Issue modifyCustomerIssue(Issue issue) ;
	public Issue addCustomerIssue(IssueDto issueDto);
	public Issue closeCustomerIssue(int Id) ;
	public Customer findCustomerById(int id);
	public List<Customer> findCustomerByName(String name);
	public Customer findCustomerByEmail(String email) ;
	public Solution addSolution(SolutionDto solutiondto);
	public List<Chat> viewAllChat(); 
	public boolean addOperator(OperatorDto operatordto);
	public String changePassword(OperatorDto operatordto);
	public List<Issue> ViewAllIssues(int code);
}
