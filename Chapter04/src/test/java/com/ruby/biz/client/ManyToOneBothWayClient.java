package com.ruby.biz.client;

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
			dataSelect(emf);
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
		
		// 부서에 대한 참조 제거
		Employee employee1 = em.find(Employee.class, 1L);
		employee1.setDept(null);		
		Employee employee2 = em.find(Employee.class, 2L);
		employee2.setDept(null);
		
		
		Department department = em.find(Department.class, 1L);
		em.remove(department);
		em.getTransaction().commit();
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
		em.persist(department);
		
		//직원 등록
		Employee employee1 = new Employee();
		employee1.setName("둘리");
		employee1.setDept(department);
		em.persist(employee1);
		
		//직원 등록
		Employee employee2 = new Employee();
		employee2.setName("도우너");
		employee2.setDept(department);
		em.persist(employee2);		
			
		System.out.println(department.getName() + "의 직원 수 : " + department.getEmployeeList().size());
		
		em.getTransaction().commit();
		em.close();
	}

}
