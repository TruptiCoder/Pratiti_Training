package com.trupti.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // makes toString, getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	private String empName;
	
	@Embedded
	private EmployeeInfo employeeInfo;
	
	public EmployeeEntity(String empName) {
		this.empName = empName;
	}
	
}
