package com.trupti.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class EmployeeInfo {
	
	private String city;
	private String email;
}
