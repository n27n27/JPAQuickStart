package com.ruby.biz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ruby.biz.domain.Department;
import com.ruby.biz.domain.Employee;

public class EmployeeDAO
{
	// JDBC 변수 선언
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// 직원 목록을 검색하여 리턴한다.
	public List<Employee> getEmployeeList()
	{
		List<Employee> employeeList = new ArrayList<Employee>();
		try
		{
			conn = getConnection();
			stmt = conn.prepareStatement("select e.id, e.name,"
					+ " d.dept_id, d.name dname"
					+ " from s_emp e, s_dept d"
					+ " where e.dept_id = d.dept_id"
					+ " order by id asc");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				//조인 검색 결과를 Employee 객체에 매핑한다.
				Employee employee = new Employee();
				employee.setId(rs.getLong("ID"));
				employee.setName(rs.getString("NAME"));
				
				//조인 검색 결과를 Department 객체에 매핑한다.
				Department department = new Department();
				department.setDeptId(rs.getLong("DEPT_ID"));
				department.setName(rs.getString("DNAME"));
				
				//직원 객체에 부서 객체를 할당한다.
				employee.setDept(department);
				employeeList.add(employee);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(rs, stmt, conn);
		}
		return employeeList;
	}
	
	// 커넥션 획득
	public Connection getConnection()
	{
		try
		{
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/test";
			conn = DriverManager.getConnection(url, "sa", "");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	// 커넥션 종료 (ResultSet, Statement, Connection)
	public void close(ResultSet rs, Statement stmt, Connection conn)
	{
		try
		{
			if(rs != null)
				rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs = null;
		}
		
		try
		{
			if(stmt != null)
				stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			stmt = null;
		}
		
		try
		{
			if(conn != null && !conn.isClosed())
				conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conn = null;
		}

	}
	
	// 커넥션 종료 (Statement, Connection)
	public void close(Statement stmt, Connection conn)
	{
		try
		{
			if(stmt != null)
				stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			stmt = null;
		}
		
		try
		{
			if(conn != null && !conn.isClosed())
				conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conn = null;
		}
	
	}
}

