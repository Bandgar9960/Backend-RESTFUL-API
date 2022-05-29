package com.BandgarIt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BandgarIt.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
