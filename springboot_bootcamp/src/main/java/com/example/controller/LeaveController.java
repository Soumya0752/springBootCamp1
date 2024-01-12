package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Leave;
import com.example.service.LeaveService;
import com.example.service.ManagerService;

@RestController
public class LeaveController 
{
	@Autowired
    private LeaveService leaveService;
	
	@Autowired
	private ManagerService managerService;

    @PostMapping("/leave/raise")
    public Leave raiseLeaveRequest(@RequestBody Leave leaveRequest) {
        return leaveService.raiseLeaveRequest(leaveRequest);
    }

    @GetMapping("/leave/{id}")
    public Leave getLeaveRequestById(@PathVariable Long id) {
        return leaveService.getLeaveRequestById(id);
    }

    @PutMapping("/leave/approve/{id}")
    public Leave approveLeaveRequest(@PathVariable Long id) {
        return leaveService.approveLeaveRequest(id);
    }
    
   
}
