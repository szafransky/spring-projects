package com.szafranski.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.szafranski.springboot.thymeleafdemo.entity.Employee;
import com.szafranski.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data
	private List<Employee> theEmployees;
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		service = theEmployeeService;
	}
	

	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> theEmployees = service.findAll();
		
		model.addAttribute("employees", theEmployees);
		
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind the form data
		Employee theEmployee = new Employee();
		
		model.addAttribute(theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save the Employee
		service.saveEmployee(theEmployee);
		//use a redirect
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
		
		//get the employee from service
		Employee theEmployee = service.findById(theId);
		//set employee as a model attribute to pre populate the form
		model.addAttribute("employee", theEmployee);
		//send this over to our form
		
		return "employees/employee-form";
	}
	
	
}
