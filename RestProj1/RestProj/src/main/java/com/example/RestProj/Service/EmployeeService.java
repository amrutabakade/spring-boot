package com.example.RestProj.Service;

import java.util.List;

import com.example.RestProj.dao.EmployeeRepository;
import com.example.RestProj.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theemployee);
	
	void deleteById(int id);
}
