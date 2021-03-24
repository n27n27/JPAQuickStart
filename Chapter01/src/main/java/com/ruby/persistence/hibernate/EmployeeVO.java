package com.ruby.persistence.hibernate;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="S_EMP")
public class EmployeeVO
{
	@Id
	private Long id;
	private String name;
	@Column(name="START_DATE")
	private Timestamp startDate;
	private String title;
	@Column(name="DEPT_NAME")
	private String deptName;	
	private Double salry;
	private String email;
}
