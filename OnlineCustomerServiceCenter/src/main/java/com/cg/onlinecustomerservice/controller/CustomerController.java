package com.cg.onlinecustomerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	@Autowired
	CustomerService service;

<<<<<<< HEAD
	
=======
	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		service.registerCustomer(customer);
		return new ResponseEntity<String>("Customer Added",HttpStatus.OK);
	}
>>>>>>> branch 'master' of https://github.com/jr5g3OnlineCustomerService/OnlineCustomerServiceCenter.git
}
