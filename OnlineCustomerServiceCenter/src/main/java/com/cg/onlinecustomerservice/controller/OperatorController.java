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

import com.cg.onlinecustomerservice.dto.IssueDto;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.service.LoginService;
import com.cg.onlinecustomerservice.service.OperatorService;

@RestController
@RequestMapping("/operator")
public class OperatorController {
	@Autowired
	OperatorService service;
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public ResponseEntity<String> loginValidation(@RequestBody Login login){
		String str=loginService.loginValidation(login);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	@PostMapping("/addCustomer")
	public ResponseEntity<Issue> addCustomerIssue(@RequestBody IssueDto issueDto) {
	Issue response=service.addCustomerIssue(issueDto);
	return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@PutMapping("/updateCustomerIssue")
	public ResponseEntity<Issue> modifyCustomerIssue(@RequestBody Issue issue){
		Issue response=service. modifyCustomerIssue(issue);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@PutMapping("/closeCustomer")
	public ResponseEntity<Issue> closeCustomerIssue(@RequestBody Issue issue){
		Issue response=service. closeCustomerIssue(issue);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerById")
	public ResponseEntity<Customer> findCustomerById(@RequestBody int code){
		Customer response=service.findCustomerById(code);
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByName")
	public ResponseEntity<List<Customer>> findCustomerByName(@RequestBody String name){
		List<Customer> response=service.findCustomerByName(name);
		return new ResponseEntity<List<Customer>>(response,HttpStatus.OK);
	}
	@GetMapping("/findCustomerByEmail")
	public ResponseEntity<Customer> findCustomerByEmail(@RequestBody String email){
		Customer response=service.findCustomerByEmail(email);
		return new ResponseEntity<Customer>(response,HttpStatus.OK);
	}
	}
	
