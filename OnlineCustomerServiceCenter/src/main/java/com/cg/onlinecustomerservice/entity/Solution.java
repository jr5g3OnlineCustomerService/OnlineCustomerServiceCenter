package com.cg.onlinecustomerservice.entity;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="solution")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="solutionId")
	private int solutionId;
	@Column
	@NotNull (message="This field cannot be empty")
	private String solutionDescription;
	@Column
	//@NotNull (message="This field cannot be empty")
	private LocalDate solutionDate;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issueId", referencedColumnName = "issueId")
	private Issue issue;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operatorId", referencedColumnName = "operatorId")
	private Operator operator;
    public Solution()
    {
    }
	public Solution(int solutionId, String solutionDescription, LocalDate solutionDate) {
		super();
		this.solutionId = solutionId;
		this.solutionDescription = solutionDescription;
		this.solutionDate = solutionDate;
	}
	/*public Operator getOperator() {
		return operator;
	}*/
	public void setOperator(Operator operator) {
		this.operator = operator;
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
	public LocalDate getSolutionDate() {
		return solutionDate;
	}
	public void setSolutionDate(LocalDate solutionDate) {
		this.solutionDate = solutionDate;
	}
	public Issue getIssue() {
		return issue;
	}
	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}