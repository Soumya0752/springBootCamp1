package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AttendanceRequest;

public interface AttendanceRequestRepository extends JpaRepository<AttendanceRequest, Long> {
}
