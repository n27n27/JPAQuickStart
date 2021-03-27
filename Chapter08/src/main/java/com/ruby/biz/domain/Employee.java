package com.ruby.biz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "dept")
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
	
	private Double salary;
	
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
