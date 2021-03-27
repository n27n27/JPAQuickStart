package com.ruby.biz.repository;

import org.springframework.data.repository.CrudRepository;

import com.ruby.biz.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>
{
	
}
