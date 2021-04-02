package com.cg.onlinecustomerservice.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="solution")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="solutionId")
	private int solutionId;

	@Column
	private String solutionDescription;

	@Column
	private Date solutionDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", referencedColumnName = "issueId")
	private Issue issue;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operatorId", referencedColumnName = "operatorId")
	private Operator operator;
	
    public Solution()
    {
    }
	public Solution(int solutionId, String solutionDescription, Date solutionDate) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
	}
	public int getSolutionId() {
		return solutionId;
	}
	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	public String getSolutionDescription() {
		return solutionDescription;
	}
	public void setSolutionDescription(String solutionDescription) {
		this.solutionDescription = solutionDescription;
	}
	public Date getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(Date solutionDate) {
		this.solutionDate = solutionDate;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	

}
