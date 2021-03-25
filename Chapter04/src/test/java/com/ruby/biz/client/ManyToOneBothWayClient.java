package com.ruby.biz.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Department;
import com.ruby.biz.domain.Employee;

public class ManyToOneBothWayClient
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		try
		{
			dataInsert(emf);
			dataDelete(emf);
//			dataSelect(emf);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			emf.close();
		}
	}
	
	private static void dataDelete(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//부서 검색
		Department department = em.find(Department.class, 1L);
		
		//직원의 부서 정보 수정
		List<Employee> employeeList = department.getEmployeeList();
		for(Employee employee : employeeList)
		{
			employee.standby();
		}		
		
		em.remove(department);
		
		em.getTransaction().commit();
		em.close();
	}
	
	private static void dataUpdate(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//신규 부서 등록
		Department department = new Department();
		department.setName("영업부");
		em.persist(department);
		
		//부서 변경
		
		Employee employee = em.find(Employee.class, 1L);
		employee.setDept(department);
		em.getTransaction().commit();
	}
	
	private static void dataSelect(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		Department department = em.find(Department.class, 1L);
		
		System.out.println("검색된 부서 : " + department.getName());
		System.out.println("부서에 소속된 직원 명단");
		for(Employee employee : department.getEmployeeList())
		{
			System.out.println(employee.getName() + "("  + employee.getDept().getName() + ")");
		}
	}
	
	private static void dataInsert(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//부서 등록
		Department department = new Department();
		department.setName("개발부");		
//		em.persist(department);
		
		//직원 여러 명등록
		for(int i = 1; i <= 5; i++)
		{
			Employee employee = new Employee();
			employee.setName("직원-" + i);
			employee.setDept(department);
			em.persist(employee);			
		}
		
		em.persist(department);		
				
		em.getTransaction().commit();
		em.close();
	}

}
