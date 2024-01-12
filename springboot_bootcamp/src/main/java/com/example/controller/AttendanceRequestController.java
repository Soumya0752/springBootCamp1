package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AttendanceRequest;
import com.example.service.AttendanceRequestService;

@RestController
@RequestMapping("/attendance")
public class AttendanceRequestController {

    @Autowired
    private AttendanceRequestService attendanceRequestService;

    @PostMapping("/raise")
    public AttendanceRequest raiseAttendanceRequest(@RequestBody AttendanceRequest attendanceRequest) {
        return attendanceRequestService.raiseAttendanceRequest(attendanceRequest);
    }

    @GetMapping("/{id}")
    public AttendanceRequest getAttendanceRequestById(@PathVariable Long id) {
        return attendanceRequestService.getAttendanceRequestById(id);
    }

    
}
