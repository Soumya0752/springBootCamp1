package com.example.model;

import java.util.List;

import com.example.entity.Employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ManagerDTO {
	private int managerId;
	@NotBlank(message = "Manager name should not be null")
	@Size(min = 2,max = 30)
	private String managerName;
	@NotBlank(message = "designnation should not be null")
	private String designation;
	private List<Employee> employees;
}
