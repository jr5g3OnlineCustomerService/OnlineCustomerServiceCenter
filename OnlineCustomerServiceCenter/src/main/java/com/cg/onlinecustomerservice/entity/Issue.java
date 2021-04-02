package com.cg.onlinecustomerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// issue Class
@Entity
@Table(name="issue")
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="issueId")
	
	private String issueID;
	
	@Column
	private String issueType;
	
	@Column
	private String description;
	
	@Column
	private String issueStatus;

	public Issue(String issueID, String issueType, String description, String issueStatus) {
		super();
		this.issueID = issueID;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
	}
   // issue
	public Issue() {}

	public String getIssueID() {
		return issueID;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
}	

