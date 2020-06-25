package com.szafranski.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.szafranski.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//	everything else is running in the back
	
	//behind the scenes JPA will create sorting method
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
