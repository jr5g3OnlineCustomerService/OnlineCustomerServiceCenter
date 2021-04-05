package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Login;

@Repository
	public interface ILoginRepository extends JpaRepository<Login, Integer>{
	
}
