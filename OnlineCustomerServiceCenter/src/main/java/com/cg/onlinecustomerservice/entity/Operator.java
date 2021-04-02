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
@Entity
@Table(name="operator")
public class Operator {
	
	public class Department {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="operatorId")
		private int operatorId;
		@Column
		private String firstName;
		@Column
		private String lastName;
		@Column
		private String email;
		
		@Column
		private String mobile;
		
		@Column
		private String city;
		
		@OneToOne(mappedBy="operator")
		private Solution solution;
		
		
		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
		private Department department;
		
		@OneToOne(mappedBy="operator")
		private Call call;
		
		public Operator()
		{}

		public Operator(int operatorId, String firstName, String lastName, String email, String mobile, String city) {
			
		}
		public Department()
		{
			
		}
		public Department(int operatorId, String firstName, String lastName, String email, String mobile, String city) {
			super();
			this.operatorId = operatorId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobile = mobile;
			this.city = city;
		}

		public int getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(int operatorId) {
			this.operatorId = operatorId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
}
	

