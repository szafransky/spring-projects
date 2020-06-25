package com.szafranski.springboot.thymeleafdemo.service;

import java.util.List;

import com.szafranski.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteById(int theId);
}
