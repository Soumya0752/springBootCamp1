package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int empId;
@Column(length = 50)	
private String empName;
private LocalDate joiningDate=LocalDate.now();
@Column(length = 50)	
private String address;

//many employees can be mapped with only one Manager
@ManyToOne
@JoinColumn(name="managerId")
@JsonIgnoreProperties("employees")
private Manager maneger;


  @OneToMany
  private List<Leave>  leave;
  
  @OneToMany
  private List<AttendanceRequest>  attendanceRequest;
  
  
  
}
