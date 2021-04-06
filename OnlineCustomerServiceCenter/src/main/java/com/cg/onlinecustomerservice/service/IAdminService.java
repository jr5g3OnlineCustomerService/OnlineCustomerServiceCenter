package com.cg.onlinecustomerservice.service;

import java.util.List;

import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.OperatorNotFoundException;

public interface IAdminService {
	public boolean addDepartment(Department dept) throws DepartmentNotFoundException;
	public boolean removeDepartment(int departmentID)throws DepartmentNotFoundException;
	public Department modifyDepartment(Department dept)throws DepartmentNotFoundException;
	public Department findDepartmentById(int id)throws DepartmentNotFoundException;
	public List<Department> findAllDepartments()throws DepartmentNotFoundException;
	public boolean addOperator(OperatorDto operatordto)throws OperatorNotFoundException;
	public boolean removeOperator(int operatorID)throws OperatorNotFoundException;
	public Operator modifyOperator(Operator operator)throws OperatorNotFoundException;
	public Operator findOperator(int id)throws OperatorNotFoundException;
	public List<Operator> findAllOperators()throws OperatorNotFoundException;
	
}
