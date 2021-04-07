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

import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.service.AdminService;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.OperatorNotFoundException;

@RestController
@RequestMapping("/admin")
public class AdminController {    //Admin is one of the three actors
	@Autowired
	AdminService service;
	@PostMapping("/addDepartment")    // adds department for whatever values given to the members
	public String addDepartment(@RequestBody Department department) throws DepartmentNotFoundException {
	if(service.addDepartment(department))
		return "Department added";
	else
		return "Could not insert";
	}
	@DeleteMapping("/deleteDepartment")  //deletes the department having the given departmentID(integer given as ip)
	public String deleteDepartment(@RequestBody int code) throws DepartmentNotFoundException{
		if(service.removeDepartment(code))
			return "Deleted";
		else
			return "department not found";
	}
	@PutMapping("/updateDepartment")    // Makes modification to department without altering primarykey and throws exception if ID not found
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) throws DepartmentNotFoundException{
		Department depart=service.modifyDepartment(department);
		return new ResponseEntity<Department>(depart,HttpStatus.OK);
	}
	@GetMapping("/findDepartment")   //Finds and shows department having given ID and throws exception if no ID number is found
	public ResponseEntity<Department> findDepartment(@RequestBody int code) throws DepartmentNotFoundException{
		Department depart=service.findDepartmentById(code);
		return new ResponseEntity<Department>(depart,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOperator") //Deletes operator having given operatorID and throws exception if integer passed does not match any existing Id no 
	public String deleteOperator(@RequestBody int code) throws OperatorNotFoundException{
		if(service.removeOperator(code))
			return "Deleted";
		else
			return "Operator not found";
	}
	
	@GetMapping("/findOperator") //Finds and shows operator having given operatorID and throws exception otherwise
	public ResponseEntity<Operator> findOperator(@RequestBody int code) throws OperatorNotFoundException{
		Operator operator=service.findOperator(code);
		return new ResponseEntity<Operator>(operator,HttpStatus.OK);
	}
	@GetMapping("/allOperators") //shows the list of operators or else gives exception if there are no operators
	public ResponseEntity<List<Operator>> findAll() throws OperatorNotFoundException{
		List<Operator> operators=service.findAllOperators();
		return new ResponseEntity<List<Operator>>(operators,HttpStatus.OK);
	}
	@PutMapping("/updateOperator")  //Modifies or updates for given ID number or exception otherwise
	public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator) throws OperatorNotFoundException{
		Operator oper=service.modifyOperator(operator);
		return new ResponseEntity<Operator>(oper,HttpStatus.OK);
	}
	@PostMapping("/addOperator")  //adds operator 
	public String addOperator(@RequestBody OperatorDto dto) {
	if(service.addOperator(dto))
		return "operator added";
	else
		return "Could not insert";
	}
	@GetMapping("/allDepartments") //Displays all departments and exception if table is empty
	public ResponseEntity<List<Department>> findAll1() throws DepartmentNotFoundException{
		List<Department> response=service.findAllDepartments();
		return new ResponseEntity<List<Department>>(response,HttpStatus.OK);
	}
	
}
