package com.example.RestProj.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestProj.Service.EmployeeService;
import com.example.RestProj.entity.Employee;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.node.ObjectNode;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	private ObjectMapper objectMapper;

	public EmployeeRestController(EmployeeService employeeService , ObjectMapper theObjectMapper) {
		this.employeeService = employeeService;
		this.objectMapper = theObjectMapper;
	}



	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee id not found -" + employeeId);
		}
		
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	@PatchMapping("/employees/{employeeId}")
	public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload)
	{
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - ");
		}
		
		if(patchPayload.containsKey("id"))
		{
			throw new RuntimeException("Employee is will not change");
		}
		
		Employee patchEmployee = apply(patchPayload, tempEmployee);
		
		Employee dbEmployee = employeeService.save(patchEmployee);
		
		return dbEmployee;
	}



	private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
		// TODO Auto-generated method stub
		// employee obj -> JSON obj
		ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
		
		//patchPayload -> JSON obj
		ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
		
		//merge update to employee node
		employeeNode.setAll(patchNode);
		
		return objectMapper.convertValue(employeeNode, Employee.class);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null)
		{
			throw new RuntimeException("Employee id not found -" + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "deleted employee id" + employeeId;
	}
	
}
