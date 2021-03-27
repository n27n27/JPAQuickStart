package com.ruby.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.biz.domain.Employee;
import com.ruby.biz.persistence.EmployeeRepository;

@Service("empService")
public class EmployeeService
{
	@Autowired
	private EmployeeRepository empRepository;
	
	public void insertEmployee(Employee employee)
	{
		empRepository.insertEmployee(employee);
	}
	
	public void updateEmployee(Employee employee)
	{
		empRepository.updateEmployee(employee);
	}
	
	public void deleteEmployee(Employee employee)
	{
		empRepository.deleteEmployee(employee);
	}
	
	public Employee getEmployee(Employee employee)
	{
		return empRepository.getEmployee(employee);
	}
	
	public List<Employee> getEmployeeList(Employee employee)
	{
		return empRepository.getEmployeeList(employee);
	}
}
