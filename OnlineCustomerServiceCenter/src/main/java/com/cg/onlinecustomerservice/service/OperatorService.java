package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
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
LoginDao loginDao;
@Autowired
CustomerDao customerDao;
@Autowired
IssueDao issueDao;
@Autowired
OperatorDao operatorDao;
@Autowired
SolutionDao solutionDao;
@Override
public String login(Login l)
{
	if(loginDao.existsById(l.getUserId()))
		return "Login successful";
	else
		return "User doesnt exist";
	}
@Override
public Issue addCustomerIssue(IssueDto issueDto){
	Issue issues=new Issue();
	issues.setIssueStatus(issueDto.getIssueStatus());
	issues.setIssueType(issueDto.getIssueType());
	issues.setDescription(issueDto.getDescription());
	Customer cust=customerDao.findCustomerById(issueDto.getCustomerID());
	issues.setCustomer(cust);
	return issueDao.save(issues);		
}
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
@Override
public Customer findCustomerById(int id)throws CustomerNotFoundException{
	if(!customerDao.findById(id).isPresent())
	throw new CustomerNotFoundException();
else
	return customerDao.findCustomerById(id);
	
}
@Override
public List<Customer> findCustomerByName(String name)throws CustomerNotFoundException
{
	if(customerDao.findCustomerByName(name)!=null)
	{
		return customerDao.findCustomerByName(name);
	}
	else
		throw new CustomerNotFoundException();
}
@Override
public Customer findCustomerByEmail(String email)throws CustomerNotFoundException
{
	if(customerDao.findCustomerByEmail(email)!=null)
		return customerDao.findCustomerByEmail(email);
	else
	throw new CustomerNotFoundException();
}
@Override
public boolean lockCustomer(int id)throws InvalidCredentialException  {
	Login login=loginDao.getLogById(id);
	if(login!=null) {
		login.setActive(false);
		loginDao.save(login);
		return true;
	}
	else
		return false;

}
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
}
