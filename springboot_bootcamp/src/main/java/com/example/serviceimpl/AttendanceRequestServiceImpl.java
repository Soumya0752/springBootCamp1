package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AttendanceRequest;
import com.example.repository.AttendanceRequestRepository;
import com.example.service.AttendanceRequestService;

@Service
public class AttendanceRequestServiceImpl implements AttendanceRequestService {

    @Autowired
    private AttendanceRequestRepository attendanceRequestRepository;

    @Override
    public AttendanceRequest raiseAttendanceRequest(AttendanceRequest attendanceRequest) {
        attendanceRequest.setApproved(false);
        return attendanceRequestRepository.save(attendanceRequest);
    }

    @Override
    public AttendanceRequest getAttendanceRequestById(Long id) {
        return attendanceRequestRepository.findById(id).orElse(null);
    }

   
}
