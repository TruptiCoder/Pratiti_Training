package com.trupti.service;

import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;

import com.trupti.dao.EmployeeDAO;
import com.trupti.dao.EmployeeDAOImpl;
import com.trupti.entity.EmployeeEntity;
import com.trupti.model.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);
	private EmployeeDAO dao = new EmployeeDAOImpl();
	private ModelMapper mapper = new ModelMapper();

	@Override
	public Optional<EmployeeDTO> addEmployee(EmployeeDTO dto) {
		logger.error(dto);
		dto.setFname(dto.getFname().toUpperCase());
		dto.setLname(dto.getLname().toUpperCase());
		
		dao.addEmployee(mapper.map(dto, EmployeeEntity.class));
		
		return Optional.empty();
	}

	@Override
	public Optional<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = dao.getAllEmployees().get();
		
		Type employeeDTOListType= new TypeToken<List<EmployeeDTO>>() {}.getType();
		List<EmployeeDTO> dtos = mapper.map(employeeEntities, employeeDTOListType);
		
//		List<EmployeeDTO> dtos = new ArrayList<>();
//		employeeEntities.forEach(t -> {
//			dtos.add(mapper.map(t, EmployeeDTO.class));
//		});
		
		return Optional.ofNullable(dtos);
	}

}
