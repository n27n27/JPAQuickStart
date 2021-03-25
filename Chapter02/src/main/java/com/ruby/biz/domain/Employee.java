package com.ruby.biz.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="S_EMP")
public class Employee
{
	@Id
	private EmployeeId empId;
	
	private String name;		
	
}
