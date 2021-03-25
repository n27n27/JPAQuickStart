package com.ruby.biz.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 25, nullable = false)
	private String name;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "DEPT_ID")
	private Department dept;
	
	public void setDept(Department department)
	{
		this.dept = department;
		
		department.getEmployeeList().add(this);		
	}
	
	public void standby()
	{
		this.dept = null;
	}
}
