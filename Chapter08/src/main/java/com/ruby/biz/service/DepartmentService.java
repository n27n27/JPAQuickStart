package com.ruby.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruby.biz.domain.Department;
import com.ruby.biz.persistence.DepartmentRepository;

@Service("deptService")
public class DepartmentService
{
	@Autowired
	private DepartmentRepository deptRepository;
	
	@Transactional
	public void insertDepartment(Department department)
	{
		deptRepository.insertDepartment(department);
	}
	
	public Department getDepartment(Department department)
	{
		return deptRepository.getDepartment(department);
	}
}
