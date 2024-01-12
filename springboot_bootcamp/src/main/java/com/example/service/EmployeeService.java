package com.example.service;

import com.example.entity.Employee;
import com.example.model.EmployeeDTO;

public interface EmployeeService {

EmployeeDTO	createEmployee(Employee employee);
EmployeeDTO getEmployeeById(int id);
}
