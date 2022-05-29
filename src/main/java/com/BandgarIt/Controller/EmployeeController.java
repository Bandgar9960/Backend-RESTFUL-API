package com.BandgarIt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BandgarIt.Model.Employee;
import com.BandgarIt.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// insert emp

	@PostMapping(value = "api/add", consumes = { "applictaion/json" }, produces = { "application/json" })
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee) {

		Employee saveEmployee = employeeService.saveEmployee(employee);

		return new ResponseEntity<Employee>(saveEmployee, HttpStatus.CREATED);

	}

	// get all emp

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmp() {

		List<Employee> allEmp = employeeService.getAllEmp();

		return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.OK);

	}

	// get emp by id

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getByIdEmp(@PathVariable int id) {

		Employee empById = employeeService.getEmpById(id);

		return new ResponseEntity<Employee>(empById, HttpStatus.OK);

	}

	// update employee
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee, @PathVariable int id) {

		Employee updateEmp = employeeService.updateEmp(employee, id);

		return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);

	}

	// delete emp
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {

		employeeService.deleteEmp(id);

		return new ResponseEntity<String>("Employee Deleted Sucessfully", HttpStatus.OK);

	}

}
