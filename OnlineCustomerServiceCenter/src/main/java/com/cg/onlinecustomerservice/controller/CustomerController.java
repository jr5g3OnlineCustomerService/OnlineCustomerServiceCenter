package com.cg.onlinecustomerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	@Autowired
	CustomerService service;
	@PostMapping("/addCustomer")
	public String registerCustomer(@RequestBody Customer customer) {
	if(service.registerCustomer(customer) != null)
		return "Customer added";
	else
		return "Could not insert";
	}
	@GetMapping("/viewIssuesById")
	public ResponseEntity<Issue> viewIssuesById(@RequestBody int code){
		Issue response=service.viewIssuesById(code);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@GetMapping("/reopenIssue")
	public ResponseEntity<Issue> reopenIssue(@RequestBody int code){
		Issue response=service.reopenIssue(code);
		return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	
	
	}