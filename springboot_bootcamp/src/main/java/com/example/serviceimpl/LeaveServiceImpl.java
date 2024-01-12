package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Leave;
import com.example.repository.LeaveRepository;
import com.example.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService
{
	@Autowired
    private LeaveRepository leaveRepository;

    @Override
    public Leave raiseLeaveRequest(Leave leave) {
        leave.setApproved(false);
        return leaveRepository.save(leave);
    }

    @Override
    public Leave getLeaveRequestById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    @Override
    public Leave approveLeaveRequest(Long id) {
        Leave leaveRequest = leaveRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setApproved(true);
            leaveRepository.save(leaveRequest);
        }
        return leaveRequest;
    }
}
