package com.cg.onlinecustomerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService service;
	
	@PostMapping("/addDepartment")
	public String addDepartment(@RequestBody Department department) {
	if(service.addDepartment(department))
		return "Department added";
	else
		return "Could not insert";
	}
	@DeleteMapping("/deleteDepartment")
	public String deleteDepartment(@RequestBody int code){
		if(service.removeDepartment(code))
			return "Deleted";
		else
			return "department not found";
	}
	@PutMapping("/updateDepartment")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
		Department depart=service.modifyDepartment(department);
		return new ResponseEntity<Department>(depart,HttpStatus.OK);
	}
	@GetMapping("/findDepartment")
	public ResponseEntity<Department> findDepartment(@RequestBody int code){
		Department depart=service.findDepartmentById(code);
		return new ResponseEntity<Department>(depart,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOperator")
	public String deleteOperator(@RequestBody int code){
		if(service.removeOperator(code))
			return "Deleted";
		else
			return "Operator not found";
	}
	
	@GetMapping("/findOperator")
	public ResponseEntity<Operator> findOperator(@RequestBody int code){
		Operator operator=service.findOperator(code);
		return new ResponseEntity<Operator>(operator,HttpStatus.OK);
	}
	
	@GetMapping("/allOperators")
	public ResponseEntity<List<Operator>> findAll(){
		List<Operator> operators=service.findAllOperators();
		return new ResponseEntity<List<Operator>>(operators,HttpStatus.OK);
	}
	@PutMapping("/updateOperator")
	public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator){
		Operator oper=service.modifyOperator(operator);
		return new ResponseEntity<Operator>(oper,HttpStatus.OK);
	}
}
