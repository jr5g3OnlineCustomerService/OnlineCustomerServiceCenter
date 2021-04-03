package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Login;
@Repository
public interface LoginDao extends JpaRepository<Login , Integer>{
	@Query(value = "from login where login.isActive=?1")
	public boolean lockCustomer(int id);
}
