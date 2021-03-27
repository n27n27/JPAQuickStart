package com.ruby.biz.domain;

import java.util.Date;

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
	
	private String name;
	
	@Column(name = "MAIL_ID")
	private String mailId;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	private String title;
	
//	Department 객체와 관계를 맺으면서 사용하지 않음
//	@Column(name = "DEPT_NAME")
//	private String deptName;
	
	private Double salary;
	
	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;
	
	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department dept;
	
	public void setDept(Department department)
	{
		this.dept = department;
		
		// Department 엔티티의 컬렉션에도 Employee 참조를 설정한다.
		department.getEmployeeList().add(this);
	}
}
