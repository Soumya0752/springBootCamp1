package com.example.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.exception.ResourceNotFound;
import com.example.model.EmployeeDTO;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import com.example.util.Converter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//call repository to save employee data in db
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	Converter converter;
	
	@Override
	public EmployeeDTO createEmployee(Employee employee) {
		Employee emp=employeeRepository.save(employee);
		return converter.convertToEmployeeDTO(emp) ;
		//return converter.
				//convertToEmployeeDTO(employeeRepository.save(employee));
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) throws ResourceNotFound {
		Optional<Employee> employee=employeeRepository.findById(id);
		Employee emp=null;
		if(employee.isPresent())
		{
			emp=employee.get();
		}
		else
		{
			throw new ResourceNotFound("Employee","Id",id);
		}
		return converter.convertToEmployeeDTO(emp);
	}

//	@Override
//	public EmployeeDTO getEmployeeById(int id) throws ResourceNotFound {
//		Employee emp=employeeRepository.findById(id).
//		orElseThrow(()->new ResourceNotFound("Employee", "Id", id));
//	}
	}

