package com.cg.onlinecustomerservice.dto;

import java.util.Date;

public class SolutionDto {
	private int solutionId;
	private String solutionDescription;
	private Date solutionDate;
	private int issueId;
	private int operatorId;
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
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public SolutionDto(int solutionId, String solutionDescription, Date solutionDate, int issueId, int operatorId) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
		this.issueId = issueId;
		this.operatorId = operatorId;
	}
	public SolutionDto() {}
}
