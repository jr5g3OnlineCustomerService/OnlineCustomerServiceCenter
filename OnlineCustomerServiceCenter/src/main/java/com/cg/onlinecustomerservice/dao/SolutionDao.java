package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Solution;
@Repository
public interface SolutionDao extends JpaRepository<Solution , Integer>{
	@Query(value = "from Solution solution where solution.solutionId=?1")
	public Solution getSolutionById(int code);
}

