package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AttendanceRequest;
import com.example.entity.Leave;
import com.example.entity.Manager;
import com.example.model.ManagerDTO;
import com.example.service.ManagerService;
import com.example.util.Converter;

import jakarta.validation.Valid;

@RestController
public class ManagerController {

	@Autowired
	private Converter converter;
	
	@Autowired
	private ManagerService managerService;
	
			@PostMapping("/createManager")
		ResponseEntity<ManagerDTO> createManager(@Valid @RequestBody ManagerDTO managerDTO)
		{
		final	Manager manager=converter.convertToManager(managerDTO);
		
		return new ResponseEntity<ManagerDTO>(managerService.createManager(manager),HttpStatus.CREATED);
		}
	
		@PostMapping("assignManager/{empId}/{mId}")
		public String assignEmployeeToManager(@PathVariable int empId,@PathVariable int mId) 
		{
	    return managerService.assignEmployeeToManager(empId, mId);
	}
		
		    @PutMapping("/manager/approve/{id}")
		    public Leave managerApproveLeaveRequest(@PathVariable Long id) {
		        return managerService.approveLeaveById(id);
		    }
		    
		    @PutMapping("/manager/approveattendance/{id}")
		    public AttendanceRequest approveAttendanceRequest(@PathVariable Long id) {
		        return managerService.approveAttendanceRequestById(id);
		    }
	}

//Task 1:leave request-where employee will raise leave request,manager will
//search based on the leave's id and approved the leave.

//Task 2:attendance request
