package com.ruby.biz.client;

import java.util.List;

import com.ruby.biz.domain.Employee;
import com.ruby.biz.repository.EmployeeDAO;

public class RelationMappingClientByJDBC
{

	public static void main(String[] args)
	{
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.getEmployeeList();
		
		for(Employee employee : employeeList)
		{
			System.out.println(employee.getName() + "직원의 부서명 : " + employee.getDept().getName());
		}
	}

}
