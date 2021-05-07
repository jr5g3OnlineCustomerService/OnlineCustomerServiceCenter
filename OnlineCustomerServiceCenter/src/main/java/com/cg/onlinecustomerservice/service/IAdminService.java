package com.cg.onlinecustomerservice.service;

import java.util.List;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;

public interface IAdminService {
	public boolean addDepartment(Department dept);
	public boolean removeDepartment(int departmentID);
	public Department modifyDepartment(Department dept);
	public Department findDepartmentById(int id);
	public List<Department> findAllDepartments();
	public boolean removeOperator(int operatorID);
	public Operator modifyOperator(Operator operator);
	public Operator findOperator(int id);
	public List<Operator> findAllOperators();
	
}
