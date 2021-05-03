package com.cg.onlinecustomerservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	@Query(value = "from Customer customer where customer.customerId=?1")
	public Customer findCustomerById(int code);
	@Query(value = "from Customer customer where customer.firstname=?1")
	public List<Customer> findCustomerByName(String name);
	@Query(value = "from Customer customer where customer.email=?1")
	public Customer findCustomerByEmail(String email);
	@Query(value = "from Customer cust where cust.password=?1 and cust.email=?2")
	public Customer customerLogin(String password,String email);
	
	
}
