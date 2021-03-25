package com.ruby.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Employee;

public class EmployeeServiceClient
{

	public static void main(String[] args)
	{
		//엔티티 매니저 팩토리 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter02");
		
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
		
		//엔티티 트랜잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try
		{
			tx.begin();
			
			// 회원 등록 요청
			Employee employee = new Employee();
			employee.setName("둘리");
			em.persist(employee);
			
			tx.commit();		
			
		}
		catch(Exception e)
		{			
			e.printStackTrace();
			
			// 트랙잭션 종료(rollback)
			tx.rollback();
		}
		finally
		{
			//엔티티 매니저 및 엔티티 매니저 팩토리 종료
			em.close();
			emf.close();
		}
	}

}
