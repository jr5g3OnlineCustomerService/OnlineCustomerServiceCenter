package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.ChatDao;
import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.InvalidCredentialException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
@Service
public class OperatorService implements IOperatorService{
@Autowired
CustomerDao customerDao;
@Autowired
IssueDao issueDao;
@Autowired
OperatorDao operatorDao;
@Autowired
SolutionDao solutionDao;
@Autowired
ChatDao chatDao;
//Add customer method
@Override
public Issue addCustomerIssue(IssueDto issueDto){
	Issue issues=new Issue();
	issues.setIssueStatus(issueDto.getIssueStatus());
	issues.setIssueType(issueDto.getIssueType());
	issues.setDescription(issueDto.getDescription());
	Customer cust=customerDao.findCustomerById(issueDto.getCustomerID());
	Operator op=operatorDao.findOperatorById(issueDto.getOperatorId());
	issues.setCustomer(cust);
	issues.setOperator(op);
	return issueDao.save(issues);		
}

//closing customer issue
@Override
public Issue closeCustomerIssue(Issue issue)throws IssueNotFoundException{	
	if(!issueDao.findById(issue.getIssueId()).isPresent())
	throw new IssueNotFoundException();
else {
	int id=issue.getIssueId();
	Issue result=issueDao.getIssueById(id);
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}
}

//modifying issue
@Override
public Issue modifyCustomerIssue(Issue issue)throws IssueNotFoundException {
	if(!issueDao.findById(issue.getIssueId()).isPresent())
		throw new IssueNotFoundException();
	else {
	int id=issue.getIssueId();
	Issue result=issueDao.findById(id).get();
	result.setDescription(issue.getDescription());
	result.setIssueType(issue.getIssueType());
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}
}

//finding customer using Id
@Override
public Customer findCustomerById(int id)throws CustomerNotFoundException{
	if(!customerDao.findById(id).isPresent())
	throw new CustomerNotFoundException();
else
	return customerDao.findCustomerById(id);
	
}
//finding customer by Name
@Override
public List<Customer> findCustomerByName(String name)throws CustomerNotFoundException
{
	if(customerDao.findCustomerByName(name)!=null)
		return customerDao.findCustomerByName(name);
	else
		throw new CustomerNotFoundException();
}

//finding customer by Email
@Override
public Customer findCustomerByEmail(String email)throws CustomerNotFoundException
{
	if(customerDao.findCustomerByEmail(email)!=null)
		return customerDao.findCustomerByEmail(email);
	else
	throw new CustomerNotFoundException();
}
@Override

//changing the active status of login
public boolean lockCustomer(int id)throws InvalidCredentialException  {
/*	Login login=loginDao.getLogById(id);
	if(login!=null) {
		login.setActive(false);
		loginDao.save(login);
		return true; 
	}
	else*/
		return false;

}

//adding solution by operator
@Override
public Solution addSolution(SolutionDto solutiondto){
	Solution soln=new Solution();
	soln.setSolutionDate(solutiondto.getSolutionDate());
	soln.setSolutionDescription(solutiondto.getSolutionDescription());
	Operator operator=operatorDao.findOperatorById(solutiondto.getOperatorId());
     soln.setOperator(operator);
	Issue issue=issueDao.getIssueById(solutiondto.getIssueId());
	soln.setIssue(issue);
	return solutionDao.save(soln);
}

@Override
public List<Chat> viewAllChat() {
     List<Chat> chat = chatDao.findAll();
     return chat;
}

@Override
public Operator operatorlogin(Operator operator) {
	// TODO Auto-generated method stub
	Operator op = operatorDao.operatorLogin(operator.getPassword(),operator.getEmail());
	return op;
}
}
