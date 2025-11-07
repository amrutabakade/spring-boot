package com.example.RestProj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestProj.dao.EmployeeRepository;
import com.example.RestProj.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	/**
	 * @param id
	 * @return
	 * @see com.example.RestProj.dao.EmployeeDAO#findById(int)
	 */
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if(result.isPresent())
		{
			theEmployee = result.get();
		}
		else
		{
			throw new RuntimeException("Did not find id -" + id);
		}
		return theEmployee;
	}


	/**
	 * @param theemployee
	 * @return
	 * @see com.example.RestProj.dao.EmployeeDAO#save(com.example.RestProj.entity.Employee)
	 */
	
	public Employee save(Employee theemployee) {
		return employeeRepository.save(theemployee);
	}


	/**
	 * @param id
	 * @see com.example.RestProj.dao.EmployeeDAO#deleteById(int)
	 */
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	
}
