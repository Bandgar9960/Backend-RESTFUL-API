package com.BandgarIt.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BandgarIt.Exception.ResourceNotFoundException;
import com.BandgarIt.Model.Employee;
import com.BandgarIt.Repository.EmployeeRepo;
import com.BandgarIt.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee saveEmp = employeeRepo.save(employee);

		return saveEmp;
	}

	@Override
	public List<Employee> getAllEmp() {

		List<Employee> findAllEmp = employeeRepo.findAll();

		return findAllEmp;
	}

	@Override
	public Employee getEmpById(int id) {
		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		/*
		 * Optional<Employee> empId = employeeRepo.findById(id);
		 * 
		 * if (empId.isPresent()) { return empId.get(); } else { throw new
		 * ResourceNotFoundException("Employee", "Id", id); }
		 */
	}

	@Override
	public Employee updateEmp(Employee employee, int id) {

		Employee getEmp = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		getEmp.setFirstname(employee.getFirstname());
		getEmp.setLastname(employee.getLastname());
		getEmp.setEmail(employee.getEmail());

		Employee updateEmp = employeeRepo.save(getEmp);

		return updateEmp;
	}

	@Override
	public void deleteEmp(int id) {
        
		//check wheather data present or not
		
	    employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		employeeRepo.deleteById(id);

	}

}