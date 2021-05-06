package com.cg.onlinecustomerservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.dto.SolutionDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.service.OperatorService;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.InvalidCredentialException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.ListEmptyException;
import com.cg.onlinecustomerservice.utils.OperatorAlreadyExistingException;
import com.cg.onlinecustomerservice.utils.OperatorNotFoundException;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/operator")
public class OperatorController {
	@Autowired
	OperatorService service;
	@Autowired
	IssueDao issueDao;
	@Autowired
	OperatorDao operatordao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	DepartmentDao departmentDao;
	@PostMapping("/login")
	public ResponseEntity<Operator> loginValidation(@RequestBody Operator operator){
		Operator str=service.operatorlogin(operator);
		if(str==null)
			throw new InvalidCredentialException();
		return new ResponseEntity<Operator>(str,HttpStatus.OK);
	}
	@PostMapping("/addOperator")  //adds operator to existing operators
	public String addOperator(@Valid @RequestBody OperatorDto dto) {
		Operator op=operatordao.checkoperator(dto.getEmail());
		if(op!=null)
			throw new OperatorAlreadyExistingException();
		Department department=departmentDao.getDeptById(dto.getDepartmentID());
	    if(department==null)
	    	throw new DepartmentNotFoundException();
		else {
	if(service.addOperator(dto))
		return "operator added";
	else
		return "Could not insert";
	}
	}
	@PostMapping("/addCustomerIssue") //adds customer having given issue(foreign key) 
	public ResponseEntity<Issue> addCustomerIssue(@Valid @RequestBody IssueDto issueDto) {	
		Customer cust=customerDao.findCustomerById(issueDto.getCustomerID());
		if(cust==null)
			throw new CustomerNotFoundException();
		else
		{
	Issue response=service.addCustomerIssue(issueDto);
	return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@PutMapping("/updateCustomerIssue")   //update issue of the customer and exception if input is invalid ie if Id does not exist
	public ResponseEntity<Issue> modifyCustomerIssue(@Valid @RequestBody Issue issue){
		if(issueDao.existsById(issue.getIssueId()))
			throw new IssueNotFoundException();
		else {
		Issue response=service. modifyCustomerIssue(issue);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@PutMapping("/closeCustomer") // close the customer by changing issue status and exception if issue id does not exist
	public ResponseEntity<Issue> closeCustomerIssue(@RequestBody Integer Id){
		if(!issueDao.existsById(Id))
			throw new IssueNotFoundException();
		else {
		Issue response=service. closeCustomerIssue(Id);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	}
	@GetMapping("/findCustomerById")  //displays customer having given Id and exception if ID does not match
	public ResponseEntity<Customer> findCustomerById(@RequestBody int code){
		Customer response=service.findCustomerById(code);
		if(response==null)
			throw new CustomerNotFoundException();
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByName")  //Takes input as string and shows the detail of customer and exception if name does not exist
	public ResponseEntity<List<Customer>> findCustomerByName(@RequestBody String name){
		List<Customer> response=service.findCustomerByName(name);
		if(response.size()<=0)
			throw new ListEmptyException();
		return new ResponseEntity<List<Customer>>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByEmail")  //Takes input as email(text) and shows customer or exception if email does not exist
	public ResponseEntity<Customer> findCustomerByEmail(@RequestBody String email){
		Customer response=service.findCustomerByEmail(email);
		if(response==null)
			throw new CustomerNotFoundException();
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	/*@PutMapping("/lockAccount") //Locks the customer with given Id by changing to In-Active or exception if ID does not exist
	public ResponseEntity<Boolean> lockCustomer(@RequestBody int code) throws InvalidCredentialException{
		boolean response=service.lockCustomer(code);
		return new ResponseEntity<Boolean>(response,HttpStatus.OK);
	}*/
	@PostMapping("/addSolution")  //Adds solution having given details and members into the tables
	public ResponseEntity<Solution> addSolution(@Valid @RequestBody SolutionDto solutiondto) {
		Issue issue=issueDao.getIssueById(solutiondto.getIssueId());
		if(issue!=null) {
			Solution response=service.addSolution(solutiondto);
			return new ResponseEntity<Solution>(response,HttpStatus.OK);
			}
		else {
			throw new IssueNotFoundException();
		}
	}
	@GetMapping("/viewChatIssue")
	public ResponseEntity<List<Chat>>viewChatIssue(){
	List<Chat> response=service.viewAllChat();
	if(response.size()<=0)
		throw new ListEmptyException();
	return new ResponseEntity<List<Chat>>(response,HttpStatus.OK);
	}
	@PutMapping("/ChangePassword")  //for given login credentials allows to update password
	public String changePassword(@Valid @RequestBody OperatorDto dto){
		if(!operatordao.existsById(dto.getOperatorId()))
			throw new OperatorNotFoundException();
		else {
		service.changePassword(dto);
		return "Updated";
	}
	}
}
