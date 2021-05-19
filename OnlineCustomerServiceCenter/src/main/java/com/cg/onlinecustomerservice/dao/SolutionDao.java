package com.cg.onlinecustomerservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Solution;
@Repository
public interface SolutionDao extends JpaRepository<Solution , Integer>{
	@Query(value = "from Solution solution where solution.solutionId=?1")
	public List<Solution> getSolutionByOpId(int code);
	
	@Query(value="from Solution solution where solution.issue.issueId=?1")
	public Solution getSolutionbyIssueId(int code);
}

