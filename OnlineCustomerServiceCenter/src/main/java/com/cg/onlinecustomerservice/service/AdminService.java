package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.OperatorNotFoundException;

@Service
public class AdminService implements IAdminService{
@Autowired
DepartmentDao deptDao;
@Autowired
OperatorDao operatorDao;
//adding department
@Override
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
//removing department
@Override
public boolean removeDepartment(int departmentID)throws DepartmentNotFoundException{ 
	boolean flag=true;
	if(flag){
		if(deptDao.findById(departmentID).isPresent()) {
			deptDao.deleteById(departmentID);}
		else
			throw new DepartmentNotFoundException();
}
	else{
		flag=false;
	}
	return flag;
	}
//modifying department name
@Override
public Department modifyDepartment(Department dept)throws DepartmentNotFoundException{
	if(!deptDao.findById(dept.getDepartmentID()).isPresent())
		throw new DepartmentNotFoundException();
	else {
	int id=dept.getDepartmentID();
	Department department=deptDao.findById(id).get();
	department.setDepartmentName(dept.getDepartmentName());
	deptDao.save(department);
	return department;
	}
}

//finding department by ID
@Override
public Department findDepartmentById(int id) throws DepartmentNotFoundException{
	if(!deptDao.findById(id).isPresent())
		throw new DepartmentNotFoundException();
	else
		return deptDao.getDeptById(id);
	//return deptDao.findById(id);
}


//removing operator
@Override
public boolean removeOperator(int operatorID)throws OperatorNotFoundException{ 
	boolean flag=true;
	if(flag){
		if(operatorDao.findById(operatorID).isPresent())
				operatorDao.deleteById(operatorID);
		else
			throw new OperatorNotFoundException();
}
	else{
		flag=false;
	}
	return flag;
	}
//modifying operator
@Override
public Operator modifyOperator(Operator operator)throws OperatorNotFoundException{
	if(!operatorDao.findById(operator.getOperatorId()).isPresent())
			throw new OperatorNotFoundException();
	else {
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
}
//finding operator using ID
@Override
public Operator findOperator(int id) throws OperatorNotFoundException{
	if(!operatorDao.findById(id).isPresent())
		throw new OperatorNotFoundException();
	else
		return operatorDao.findOperatorById(id);
	
}
//view all operators
@Override
public List<Operator> findAllOperators()throws OperatorNotFoundException{
	List<Operator> operators = operatorDao.findAll();
	if(operators!=null) {
	return operators;
	}
	else
		throw new OperatorNotFoundException();
}
//view all department
@Override
public List<Department> findAllDepartments() throws DepartmentNotFoundException{
	List<Department> departments = deptDao.findAll();
	if(departments!=null) {
		return departments;
	}
	else
		throw new DepartmentNotFoundException();
}

}
