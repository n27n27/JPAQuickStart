package com.ruby.persistence.jdbc;

import java.sql.Timestamp;
import java.util.List;

public class EmployeeServiceClient
{
	public static void main(String[] args)
	{
		EmployeeVO vo = new EmployeeVO();
		vo.setName("홍길동");
		vo.setStartDate(new Timestamp(System.currentTimeMillis()));
		vo.setTitle("과장");
		vo.setDeptName("총무부");
		vo.setSalary(2700.00);
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insertEmployee(vo);
		
		List<EmployeeVO> employeeList = employeeDAO.getEmployeeList();
		for(EmployeeVO employee: employeeList)
		{
			System.out.println("---> " + employee.toString());
		}
	}
}
