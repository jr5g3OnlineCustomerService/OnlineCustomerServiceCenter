package com.cg.onlinecustomerservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
// issueClass
@Entity
@Table(name="issue")
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="issueId")
	private int issueID;
	
	@OneToOne(mappedBy="issue")
	private Solution solution;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
	
	@Column
	private String issueType;
	
	@Column
	private String description;
	
	@Column
	private String issueStatus;
	
	public Issue(int issueID, String issueType, String description, String issueStatus) {
		super();
		this.issueID = issueID;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
	}
   
	public Issue() {}
	
	public Solution getSolution() {
		return solution;
	}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
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

