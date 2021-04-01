package com.cg.onlinecustomerservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Solution")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="solutionId")
	private int solutionId;

	@Column
	private String solutionDescription;

	@Column
	private Date solutionDate;
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

}
