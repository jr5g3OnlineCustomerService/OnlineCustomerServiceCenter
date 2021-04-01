package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao dao;
	public void registerCustomer(Customer customer) {
		dao.save(customer);
	}
}
