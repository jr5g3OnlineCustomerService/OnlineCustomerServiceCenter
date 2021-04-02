package com.cg.onlinecustomerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinecustomerservice.entity.Issue;
@Repository
public interface IssueDao extends JpaRepository<Issue , Integer>{

}
