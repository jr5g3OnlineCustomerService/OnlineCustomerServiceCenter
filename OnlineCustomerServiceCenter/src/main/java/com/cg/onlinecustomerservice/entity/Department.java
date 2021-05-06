package com.cg.onlinecustomerservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="departmentID")
	private int departmentID;
	@Column(name="departmentName")
	@NotNull(message="This cannot be empty")
	private String departmentName;
	public Department(int departmentID, String departmentName) { // department 
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}
	
	@OneToMany(mappedBy="department")
	private List<Operator> operator;
	public Department() {}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
