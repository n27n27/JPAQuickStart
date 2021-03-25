package com.ruby.biz.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import com.ruby.biz.domain.Employee;

public class EmployeeServiceClient
{

	public static void main(String[] args)
	{
		//엔티티 매니저 팩토리 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter03");
		
		//엔티티 매니저 생성
		EntityManager em = emf.createEntityManager();
				
		//엔티티 트랙잭션 생성
		EntityTransaction tx = em.getTransaction();
		
		try
		{
			
//			//직원 엔티티 생성 및 초기화
//			Employee employee = new Employee();
//			employee.setName("둘리");
//			
//			//트랜잭션 시작
//			tx.begin();
//			
//			//직원등록
//			em.persist(employee);
//				
//			//트랜잭션 종료
//			tx.commit();
			
			//직원 검색
			Employee findEmp = em.find(Employee.class, 1L);
			
			//직원 이름 변경
			tx.begin();
			findEmp.setName("도우너");
			tx.commit();
				
		}
		catch(Exception e)
		{			
			e.printStackTrace();
			//트랜잭션 종료
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
