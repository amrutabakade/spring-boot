package com.example.RestProj.dao;

import java.util.List;

import com.example.RestProj.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee theemployee);
	
	void deleteById(int id);
}
