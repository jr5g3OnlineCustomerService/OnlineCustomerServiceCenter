package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.ChatDao;
import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.entity.Solution;
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
@Autowired
DepartmentDao departMentDao;
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
@Override
public boolean addOperator(OperatorDto operatordto){
	Operator operator=new Operator();
	operator.setFirstName(operatordto.getFirstName());
	operator.setLastName(operatordto.getLastName());
	operator.setEmail(operatordto.getEmail());
	operator.setCity(operatordto.getCity());
	operator.setMobile(operatordto.getMobile());
	operator.setPassword(operatordto.getPassword());
	Department dept=departMentDao.getDeptById(operatordto.getDepartmentID());
	operator.setDepartment(dept);
	operatorDao.save(operator);
	return true;
}

//closing customer issue
@Override
public Issue closeCustomerIssue(int Id){	
	Issue result=issueDao.getIssueById(Id);
	result.setIssueStatus("Closed");
	issueDao.save(result);
	return result;
}
//modifying issue
@Override
public Issue modifyCustomerIssue(Issue issue){
	int id=issue.getIssueId();
	Issue result=issueDao.getIssueById(id);
	result.setDescription(issue.getDescription());
	result.setIssueType(issue.getIssueType());
	result.setIssueStatus(issue.getIssueStatus());
	issueDao.save(result);
	return result;
}

//finding customer using Id
@Override
public Customer findCustomerById(int id){
	return customerDao.findCustomerById(id);
}
//finding customer by Name
@Override
public List<Customer> findCustomerByName(String name)
{
	return customerDao.findCustomerByName(name);
}

//finding customer by Email
@Override
public Customer findCustomerByEmail(String email)
{
	return customerDao.findCustomerByEmail(email);
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
	Operator op = operatorDao.operatorLogin(operator.getPassword(),operator.getEmail());
	return op;
}
@Override
public String changePassword(OperatorDto operatordto) {
	int id=operatordto.getOperatorId();
	Operator dto=operatorDao.findOperatorById(id);
	dto.setPassword(operatordto.getPassword());
	operatorDao.save(dto);
	return "updated";
}
@Override
public List<Issue> ViewAllIssues() {
	List<Issue> response=issueDao.findAll();
	return response;
}

}
