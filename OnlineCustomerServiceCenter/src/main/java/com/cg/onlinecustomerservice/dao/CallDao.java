package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Call;
@Repository
public interface CallDao extends JpaRepository<Call , Integer>{

}
