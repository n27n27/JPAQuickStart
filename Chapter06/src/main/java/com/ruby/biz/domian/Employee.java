package com.ruby.biz.domian;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
//@NamedQueries({
//	@NamedQuery(name = "Employee.searchById", query = "SELECT e FROM Employee e WHERE e.id = :searchKeyword"),
//	@NamedQuery(name = "Employee.searchByName", query = "SELECT e FROM Employee e WHERE e.name like :searchKeyword")
//})
//@NamedNativeQueries({
//	@NamedNativeQuery(name = "Employee.searchByDeptId",
//			query = "SELECT E.ID, E.NAME ename, E.SALARY, D.NAME dname"
//					+ " FROM S_EMP E, S_DEPT D"
//					+ " WHERE E.DEPT_ID = D.DEPT_ID"
//					+ " AND E.DEPT_ID = :deptId")
//})
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
	
	@Column(name = "DEPT_NAME")
	private String deptName;
	
	private Double salary;
	
	@Column(name = "COMMISSION_PCT")
	private Double commissionPct;
	
	@ManyToOne
	@JoinColumn(name = "DEPT_ID")
	private Department dept;
	
	public void setDept(Department department)
	{
		this.dept = department;
		if(department != null)
			department.getEmployeeList().add(this);
	}
}
