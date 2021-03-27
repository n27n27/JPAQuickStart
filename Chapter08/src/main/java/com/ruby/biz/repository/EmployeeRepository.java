package com.ruby.biz.repository;

import org.springframework.data.repository.CrudRepository;

import com.ruby.biz.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{

}
