package com.ruby.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Department;
import com.ruby.biz.domain.Employee;

public class ManyToOneOneWayClient
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		try
		{
			dataInsert(emf);
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
		
		em.getTransaction().commit();
		em.close();
	}

}
