package com.ruby.biz.client;

import java.util.Date;

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
			//엔티티 생성 및 초기화
			Employee employee = new Employee();
			employee.setId(1L);
			employee.setName("둘리");
			employee.setMailId("guruM");
			employee.setStartDate(new Date());
			employee.setTitle("과장");
			employee.setDeptName("총무부");
			employee.setSalary(2500.00);
			employee.setCommissionPct(12.50);
			
			//회원 등록 요청
			tx.begin();
			em.persist(employee);
			tx.commit();
			
			//등록한 회원 검색
			Employee findEmployee = em.find(Employee.class, 1L);
			System.out.println("검색한 회원 정보");
			System.out.println(findEmployee.toString());
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
