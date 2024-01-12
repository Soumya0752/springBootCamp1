package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
