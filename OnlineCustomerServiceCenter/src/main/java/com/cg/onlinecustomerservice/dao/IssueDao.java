package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
@Repository
public interface IssueDao extends JpaRepository<Issue , Integer>{
	@Query(value = "from Issue issue where issue.issueId=?1")
	public Issue getIssueById(int code);
}
