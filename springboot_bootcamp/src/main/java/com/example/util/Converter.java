package com.example.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entity.Employee;
import com.example.entity.Manager;
import com.example.model.EmployeeDTO;
import com.example.model.ManagerDTO;

@Component
public class Converter {

	//convert from DTO to Entity
	public  Employee  convertToEmployee(EmployeeDTO employeeDTO )
	{
		Employee employee=new Employee();
		if(employeeDTO!=null)
		{
			BeanUtils.copyProperties(employeeDTO, employee);
		}
		return employee;
	}
	
	
	//convert from Entity to DTO
		public  EmployeeDTO  convertToEmployeeDTO(Employee employee )
		{
			EmployeeDTO employeeDTO=new EmployeeDTO();
			if(employee!=null)
			{
				BeanUtils.copyProperties(employee, employeeDTO);
			}
			return employeeDTO;
		}
		
		
		//convert from DTO to Entity
		public  Manager  convertToManager(ManagerDTO managerDTO )
		{
			Manager manager=new Manager();
			if(managerDTO!=null)
			{
				BeanUtils.copyProperties(managerDTO, manager);
			}
			return manager;
		}
		
		
		//convert from Entity to DTO
			public  ManagerDTO  convertToManagerDTO(Manager manager )
			{
				ManagerDTO managerDTO=new ManagerDTO();
				if(manager!=null)
				{
					BeanUtils.copyProperties(manager, managerDTO);
				}
				return managerDTO;
			}
}
