package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Operator;
@Repository
public interface OperatorDao extends JpaRepository<Operator , Integer>{

}
