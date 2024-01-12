package com.example.service;

import com.example.entity.Leave;

public interface LeaveService
{
	    Leave raiseLeaveRequest(Leave leave);
	    Leave getLeaveRequestById(Long id);
	    Leave approveLeaveRequest(Long id);
}
