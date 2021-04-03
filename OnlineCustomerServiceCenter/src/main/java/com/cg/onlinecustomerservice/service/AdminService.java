package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;

@Service
public class AdminService {
@Autowired
DepartmentDao deptDao;
@Autowired
OperatorDao operatorDao;
public boolean addDepartment(Department dept){
	boolean flag=true;
	if(flag){
	deptDao.save(dept);
}
	else{
		flag=false;
	}
	return flag;
}

public boolean removeDepartment(int departmentID){ 
	boolean flag=true;
	if(flag){
	deptDao.deleteById(departmentID);
}
	else{
		flag=false;
	}
	return flag;
	}

public Department modifyDepartment(Department dept){

	int id=dept.getDepartmentID();
	Department department=deptDao.findById(id).get();
	department.setDepartmentName(dept.getDepartmentName());
	deptDao.save(department);
	return department;
}
public Department findDepartmentById(int id) {
	return deptDao.getDeptById(id);
	//return deptDao.findById(id);
}
public boolean addOperator(Operator operator){
	boolean flag=true;
	if(flag){
	operatorDao.save(operator);
}
	else{
		flag=false;
	}
	return flag;
}
public boolean removeOperator(int operatorID){ 
	boolean flag=true;
	if(flag){
	operatorDao.deleteById(operatorID);
}
	else{
		flag=false;
	}
	return flag;
	}
public Operator modifyOperator(Operator operator){

	int id=operator.getOperatorId();
	Operator oper=operatorDao.findById(id).get();
	oper.setFirstName(operator.getFirstName());
	oper.setLastName(operator.getLastName());
	oper.setMobile(operator.getMobile());
	oper.setCity(operator.getCity());
	operatorDao.save(oper);
	return oper;
}
public Operator findOperator(int id) {
	return operatorDao.findOperatorById(id);
	 //return operatorDao.findById(id);
}
public List<Operator> findAllOperators(){
	List<Operator> operators = operatorDao.findAll();
	return operators;
}
}
