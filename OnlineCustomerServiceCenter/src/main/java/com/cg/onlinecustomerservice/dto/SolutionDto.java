package com.cg.onlinecustomerservice.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class SolutionDto {
	private int solutionId;
	@NotNull (message="This field cannot be empty")
	private String solutionDescription;
	//@NotNull (message="This field cannot be empty")
	private LocalDate solutionDate;
	@NotNull (message="This field cannot be empty")
	private int issueId;
	@NotNull (message="This field cannot be empty")
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
	public LocalDate getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(LocalDate solutionDate) {
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
	public SolutionDto(int solutionId, String solutionDescription, LocalDate solutionDate, int issueId, int operatorId) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
		this.issueId = issueId;
		this.operatorId = operatorId;
	}
	public SolutionDto() {}
}
