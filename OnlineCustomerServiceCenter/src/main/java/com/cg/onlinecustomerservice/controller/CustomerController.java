package com.cg.onlinecustomerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	CustomerService service;

	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		service.registerCustomer(customer);
		return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
	}
}
