package com.trupti.service;

import java.util.List;
import java.util.Optional;

import com.trupti.model.EmployeeDTO;

public interface EmployeeService {
	
	Optional<EmployeeDTO> addEmployee(EmployeeDTO dto);
	Optional<List<EmployeeDTO>> getAllEmployees();

}
