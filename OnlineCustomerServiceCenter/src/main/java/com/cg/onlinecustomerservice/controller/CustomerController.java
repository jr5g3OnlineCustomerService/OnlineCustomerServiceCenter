package com.cg.onlinecustomerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.service.CustomerService;
import com.cg.onlinecustomerservice.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService service;
     @Autowired
	LoginService loginService;
     @PostMapping("/login")
	public ResponseEntity<String> loginValidation(@RequestBody Login login){
		String str=loginService.loginValidation(login);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@PostMapping("/addCustomer")
	public String registerCustomer(@RequestBody Customer customer) {
	if(service.registerCustomer(customer) != null)
		return "Customer added";
	else
		return "Could not insert";
	}
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customer>> ViewAllCustomers(){
		List<Customer> response=service.ViewAllCustomers();
		return new ResponseEntity<List<Customer>>(response,HttpStatus.OK);
	}
	@GetMapping("/viewIssuesById")
	public ResponseEntity<Issue> viewIssuesById(@RequestBody int code){
		Issue response=service.viewIssuesById(code);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@GetMapping("/allIssues")
	public ResponseEntity<List<Issue>> ViewAllIssues(){
		List<Issue> issues=service.ViewAllIssues();
		return new ResponseEntity<List<Issue>>(issues,HttpStatus.OK);
	}
	@GetMapping("/viewSolutionsById")
	public ResponseEntity<Solution> viewSolutionsById(@RequestBody int code){
		Solution response=service.viewSolutionsById(code);
		return new ResponseEntity<Solution>(response,HttpStatus.OK);
	}
	@GetMapping("/allSolutions")
	public ResponseEntity<List<Solution>> ViewAllSolution(){
		List<Solution> issues=service.ViewAllSolutions();
		return new ResponseEntity<List<Solution>>(issues,HttpStatus.OK);
	}
	@PutMapping("/ChangePassword")
	public String changePassword(Login login) {
		if(service.changePassword(login) != null)
		  return "Changed Password Successfully";
		else
		   return "Could Not Change";
	}
	@PutMapping("/reopenissue")
	public ResponseEntity<Issue> changeIssueStatus(@RequestBody int id) {
		Issue issues=service.reOpenIssue(id);
		return new ResponseEntity<Issue>(issues,HttpStatus.OK);
	}
}
