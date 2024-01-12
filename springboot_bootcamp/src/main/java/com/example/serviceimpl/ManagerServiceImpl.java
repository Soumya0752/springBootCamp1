package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AttendanceRequest;
import com.example.entity.Employee;
import com.example.entity.Leave;
import com.example.entity.Manager;
import com.example.exception.ResourceNotFound;
import com.example.model.ManagerDTO;
import com.example.repository.AttendanceRequestRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.LeaveRepository;
import com.example.repository.ManagerRepository;
import com.example.service.ManagerService;
import com.example.util.Converter;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
    private LeaveRepository leaveRepository;
	
	@Autowired
	private AttendanceRequestRepository attendanceRequestRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public ManagerDTO createManager(Manager manager) {
		// TODO Auto-generated method stub
		return converter.
				convertToManagerDTO(managerRepository.save(manager));
	}

	@Override
	public String assignEmployeeToManager(int empId, int mId) {
		Employee emp=employeeRepository.findById(empId)
				.orElseThrow(()->new ResourceNotFound("Employee", "Id", empId));
		
		Manager manager=managerRepository.findById(mId)
				.orElseThrow(()->new ResourceNotFound("Manager", "Id", mId));
		emp.setManeger(manager);
		employeeRepository.save(emp);
		
		return "Employee " +emp.getEmpName()+ 
				" is mapped with Manager "+ manager.getManagerName();
	}

	@Override
	public Leave approveLeaveById(Long id) 
	{
	    Leave leaveRequest = leaveRepository.findById(id).orElse(null);
	
	    if (leaveRequest != null && !leaveRequest.isApproved()) {
	        leaveRequest.setApproved(true);
	        leaveRepository.save(leaveRequest);
	    }
	
	    return leaveRequest;
		    
		
	}
	
	 @Override
	    public AttendanceRequest approveAttendanceRequestById(Long id) {
	        AttendanceRequest attendanceRequest = attendanceRequestRepository.findById(id).orElse(null);
	        if (attendanceRequest != null && !attendanceRequest.isApproved()) {
	            attendanceRequest.setApproved(true);
	            attendanceRequestRepository.save(attendanceRequest);
	        }
	        return attendanceRequest;
	    }

	    

}
