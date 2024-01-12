package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.model.EmployeeDTO;
import com.example.service.EmployeeService;
import com.example.util.Converter;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
EmployeeService employeeService;
	@Autowired
	Converter converter;
	
@PostMapping("/createEmployee")
ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
{
	//convert from DTO to entity,then will send to service
	final Employee employee=converter.convertToEmployee(employeeDTO);
	return new ResponseEntity<EmployeeDTO>(employeeService.
			createEmployee(employee),HttpStatus.CREATED);
}

@GetMapping("/getEmpById/{eid}")
EmployeeDTO getEmployeeById(@PathVariable("eid") int id) 
{
	return employeeService.getEmployeeById(id);
}
}
