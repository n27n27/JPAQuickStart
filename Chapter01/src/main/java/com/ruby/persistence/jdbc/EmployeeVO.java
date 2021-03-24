package com.ruby.persistence.jdbc;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmployeeVO
{
	private Long id;
	private String name;
	private Timestamp startDate;
	private String title;
	private String deptName;
	private Double salary;	
	
}
