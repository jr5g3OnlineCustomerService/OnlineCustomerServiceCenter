package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Department;
@Repository
public interface DepartmentDao extends JpaRepository<Department , Integer>{
	@Query(value = "from Department dept where dept.departmentID=?1")
	public Department getDeptById(int code);
	
	@Query(value="from Department dept where dept.departmentName=?1")
	public Department checkDept(String name);
}
