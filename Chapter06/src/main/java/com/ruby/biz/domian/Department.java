package com.ruby.biz.domian;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "employeeList")
@Entity
@Table(name = "S_DEPT")
public class Department
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_ID")
	private Long deptId;
	
	private String name;
	
	@OrderColumn(name="EMP_IDX")
	@OneToMany(mappedBy = "dept", cascade = CascadeType.PERSIST)
	private List<Employee> employeeList = new ArrayList<>();
}
