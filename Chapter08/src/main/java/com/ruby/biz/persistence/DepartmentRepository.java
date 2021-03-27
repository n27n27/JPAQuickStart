package com.ruby.biz.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ruby.biz.domain.Department;

@Repository
public class DepartmentRepository
{
	@PersistenceContext
	private EntityManager em;
	
	public void insertDepartment(Department department)
	{
		System.out.println("===> JPA로 insertDepartment() 기능 처리");
		em.persist(department);
	}
	
	public Department getDepartment(Department department)
	{
		System.out.println("===> JPA로 getDepartment() 기능 처리");
		return em.find(Department.class, department.getDeptId());
	}
}
