package com.example.RestProj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.RestProj.Service.EmployeeService;
import com.example.RestProj.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel)
	{
		
		List<Employee> theEmployee = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployee);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model theModel)
	{
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String addEmployee(Employee theEmployee)
	{
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel)
	{
		Employee theEmployee = employeeService.findById(id);
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("employeeId") int id)
	{
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
}
