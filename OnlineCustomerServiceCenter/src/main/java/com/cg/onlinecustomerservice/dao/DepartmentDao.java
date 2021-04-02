package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Department;
@Repository
public interface DepartmentDao extends JpaRepository<Department , Integer>{

}
