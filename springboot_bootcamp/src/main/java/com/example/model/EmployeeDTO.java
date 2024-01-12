package com.example.model;

import java.time.LocalDate;

import com.example.entity.Manager;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {
private int empId;
@NotNull(message = "Employee name should not be null")
@Size(min = 2,max = 30)
private String empName;
private LocalDate joiningDate=LocalDate.now();
@NotNull(message = "Employee address should not be null")
private String address;
private Manager maneger;
}

//address:Employee address should not be null
//empName:Employee name should not be null