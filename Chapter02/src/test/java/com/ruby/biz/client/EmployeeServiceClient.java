package com.ruby.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Employee;
import com.ruby.biz.domain.EmployeeId;

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
			// 회원 정보 검색 요청
			EmployeeId empId = new EmployeeId(1L, "guest123");
			Employee findEmployee = em.find(Employee.class, empId);
			System.out.println("검색된 직원의 정보 : " + findEmployee.toString());			
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
