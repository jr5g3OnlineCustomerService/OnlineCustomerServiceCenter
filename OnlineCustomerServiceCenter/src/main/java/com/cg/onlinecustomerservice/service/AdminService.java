package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.entity.Department;

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

}
