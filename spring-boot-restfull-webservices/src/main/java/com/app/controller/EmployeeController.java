package com.app.controller;

import java.util.List;
import java.util.Optional;
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

import com.app.entity.Employee;
import com.app.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/")
	public ResponseEntity<List<Employee>> getListemp() {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		return employeeRepository.findById(id);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
	}

	@PutMapping(value = "/")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id) {
		employeeRepository.deleteById(id);
		return new ResponseEntity<String>("Employee Deleted by Id: " + id, HttpStatus.OK);
	}

}
