package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;

@Service
public class AdminService implements IAdminService{
@Autowired
DepartmentDao departMentDao;
@Autowired
OperatorDao operatorDao;
//adding department
@Override
public boolean addDepartment(Department dept){
	departMentDao.save(dept);
	return true;
}
//removing department
@Override
public boolean removeDepartment(int departmentID){
	departMentDao.deleteById(departmentID);
	return true;
	}
//modifying department name
@Override
public Department modifyDepartment(Department dept){
	int id=dept.getDepartmentID();
	Department department=departMentDao.findById(id).get();
	department.setDepartmentName(dept.getDepartmentName());
	departMentDao.save(department);
	return department;
}

//finding department by ID
@Override
public Department findDepartmentById(int id){
		return departMentDao.getDeptById(id);
	
}
//removing operator
@Override
public boolean removeOperator(int operatorID){ 
	operatorDao.deleteById(operatorID);
	return true;
}
//modifying operator
@Override
public Operator modifyOperator(Operator operator){
	int id=operator.getOperatorId();
	Operator oper=operatorDao.findById(id).get();
	oper.setFirstName(operator.getFirstName());
	oper.setLastName(operator.getLastName());
	oper.setMobile(operator.getMobile());
	oper.setEmail(operator.getEmail());
	oper.setCity(operator.getCity());
	operatorDao.save(oper);
	return oper;
}
//finding operator using ID
@Override
public Operator findOperator(int id){
	return operatorDao.findOperatorById(id);
}
//view all operators
@Override
public List<Operator> findAllOperators(){
	List<Operator> operators = operatorDao.findAll();
	return operators;
}
//view all department
@Override
public List<Department> findAllDepartments(){
	List<Department> departments = departMentDao.findAll();
	return departments;
}
}
