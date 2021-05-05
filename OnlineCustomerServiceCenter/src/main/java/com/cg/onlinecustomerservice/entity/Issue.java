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
import javax.validation.constraints.NotNull;
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
	@NotNull (message="This field cannot be empty")
	private String issueType;
	@Column
	@NotNull (message="This field cannot be empty")
	private String description;
	@Column
	@NotNull (message="This field cannot be empty")
	private String issueStatus;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operatorId", referencedColumnName = "operatorId")
	private Operator operator;
		public Issue(int issueId, String issueType, String description, String issueStatus) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.description = description;
		this.issueStatus = issueStatus;
		
	}
	
	public Operator getOperator() {
			return operator;
		}
		public void setOperator(Operator operator) {
			this.operator = operator;
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

