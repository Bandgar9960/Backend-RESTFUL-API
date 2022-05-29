package com.BandgarIt.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BandgarIt.Model.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmp();

	Employee getEmpById(int id);

	Employee updateEmp(Employee employee, int id);
	
	void deleteEmp(int id);

}
