package com.ruby.biz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ruby.biz.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
	List<Employee> findByName(String name);
	
	Page<Employee> findByNameContaining(String name, Pageable paging);
	
	List<Employee> findByNameContainingOrMailIdContaining(String name, String mailId);
	
	List<Employee> findByMailIdContainingOrderByNameDesc(String mailId);
	
	@Query("SELECT emp.id, emp.name, emp.salary "
			+ " FROM Employee emp"
			+ " WHERE emp.name like %:name%"
			+ " ORDER BY emp.id DESC")
	List<Object[]> findByJPQL(@Param("name") String name, Pageable paging);
	
	@Query(value="select id, name, salary"
			+ " from s_emp"
			+ " where name like '%'||?1||'%'"
			+ " order by id desc",
				nativeQuery = true)
	List<Object[]> findByNativeQuery(String name);
}
