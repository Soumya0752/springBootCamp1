package com.example.service;

import com.example.entity.AttendanceRequest;

public interface AttendanceRequestService 
{
    AttendanceRequest raiseAttendanceRequest(AttendanceRequest attendanceRequest);
    AttendanceRequest getAttendanceRequestById(Long id);
   
}
