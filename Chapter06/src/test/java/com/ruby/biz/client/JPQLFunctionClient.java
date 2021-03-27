package com.ruby.biz.client;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ruby.biz.domian.Department;
import com.ruby.biz.domian.Employee;

public class JPQLFunctionClient
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter06");
		
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
	
	private static void dataSelect(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP FROM Department d";
		
		TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
				
		List<Object[]> resultList = query.getResultList();
		
		for(Object[] result: resultList)
		{			
			System.out.println("---> " + Arrays.toString(result));
		}
		
		em.close();
	}
	
	private static void dataInsert(EntityManagerFactory emf)
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Department department1 = new Department();
		department1.setName("개발부");
		for(int i = 1; i <= 3; i++)
		{
			Employee employee = new Employee();
			employee.setName("개발직원 " + i);
			employee.setSalary(i * 12700.00);
			employee.setMailId("Dev-" + i);
			employee.setDept(department1);
		}
		
		em.persist(department1);
		
		Department department2 = new Department();
		department2.setName("영업부");
		for(int i = 1; i <= 3; i++)
		{
			Employee employee = new Employee();
			employee.setName("영업직원 " + i);
			employee.setSalary(i * 27300.00);
			employee.setMailId("Sale-" + i);
			employee.setDept(department2);
		}
		
		em.persist(department2);
		
		Department department3 = new Department();
		department3.setName("인재개발부");
		em.persist(department3);
		
		//부서 정보가 없는 새로운 직원 추가
		Employee employee = new Employee();
		employee.setName("아르바이트");
		employee.setMailId("Alba-01");
		employee.setSalary(10000.00);
		em.persist(employee);
		
		// 이름이 영업부인 새로운 직원 추가
		Employee employee2 = new Employee();
		employee2.setName("영업부");
		em.persist(employee2);
		
		em.getTransaction().commit();
		em.close();
	}

}
