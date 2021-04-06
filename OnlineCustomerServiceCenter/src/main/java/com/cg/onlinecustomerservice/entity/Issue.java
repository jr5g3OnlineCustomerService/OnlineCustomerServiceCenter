package com.cg.onlinecustomerservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// issueClass
@Entity
@Table(name="issue")
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="issueId")
	private int issueId;
	
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
	
	public Issue(int issueId, String issueType, String description, String issueStatus) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
	}
   
	public Issue() {}
	//public Customer getCustomer() {
	//	return customer;
	//}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//public Solution getSolution() {
	//	return solution;
	//}
	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
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

