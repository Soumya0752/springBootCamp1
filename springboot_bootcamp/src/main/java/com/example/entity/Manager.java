package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Manager {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int managerId;
@Column(name = "name",length = 30)	
private String managerName;
@Column(name = "designation",length = 30)	
private String designation;

//one manager can have many employees under his/her reporting
@OneToMany(mappedBy = "maneger",cascade = CascadeType.ALL)
@JsonIgnoreProperties("maneger")
private List<Employee> employees;
}
//maneger_managerId
