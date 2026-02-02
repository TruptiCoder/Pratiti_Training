package com.trupti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Emp2")
public class EmployeeEntity {
	@Id
	@Column(name = "eid")
	private Integer empId;
	@Column(name="ename")
	private String empName;
}
