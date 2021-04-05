package com.cg.onlinecustomerservice.dto;
public class IssueDto {
	private int issueID;
	private int customerID;
	private String issueType;
	private String description;
	private String issueStatus;
	public int getIssueID() {
		return issueID;
	}
	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomer(int customerID) {
		this.customerID = customerID;
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
	public IssueDto(int issueID,  int customerID, String issueType, String description,
			String issueStatus) {
		super();
		this.issueID = issueID;
		this.customerID = customerID;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
	}
	public IssueDto() {}
	
}
