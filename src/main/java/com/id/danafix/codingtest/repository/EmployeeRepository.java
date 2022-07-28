package com.id.danafix.codingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.id.danafix.codingtest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
	@Query(value = "select * from employee e where e.email=:email ",nativeQuery = true)
	Employee findByEmail1(@Param("email") String email);
	
	
	
}
