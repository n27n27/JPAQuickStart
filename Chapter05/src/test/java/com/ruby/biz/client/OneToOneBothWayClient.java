package com.ruby.biz.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Employee;
import com.ruby.biz.domain.EmployeeCard;

public class OneToOneOneBothClient
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter05");
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
		
		Employee employee = em.find(Employee.class, 1L);
		System.out.println("직원을 통한 사원증 정보 접근: " + employee.getCard().toString());
	}
	
	private static void dataInsert(EntityManagerFactory emf) throws ParseException
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// 사원증 등록
		EmployeeCard card = new EmployeeCard();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		card.setExpireDate(dateFormat.parse("2025-12-31"));
		card.setRole("MASTER");		
		em.persist(card);
		
		// 직원 등록
		Employee employee = new Employee();
		employee.setName("둘리");
		employee.setEmployeeCard(card);
		em.persist(employee);		
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("사원증을 통한 직원 정보 접근 : " + card.getEmployee().getName());
		System.out.println("직원을 통한 사원증 정보 접근 : " + employee.getCard().getExpireDate());
	}
}
