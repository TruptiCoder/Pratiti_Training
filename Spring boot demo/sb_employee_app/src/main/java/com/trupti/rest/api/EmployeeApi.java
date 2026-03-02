package com.trupti.rest.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trupti.model.EmployeeModel;
import com.trupti.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeApi {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeApi.class);

	@Autowired
	private EmployeeService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeModel... employeeModels) {
		List<Integer> res = service.addEmployees(employeeModels);
		StringBuilder str = new StringBuilder();
		if (res.size() > 0) {
			res.forEach(e -> {
				str.append("Employee with Id: " + e + " already exists!\n");
			});
		}
		Integer added = employeeModels.length - res.size();
		str.append("Total: " + added + " Employees added successfully");
		logger.info(str.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(str.toString());
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeModel emp) {
		boolean res = service.updateEmployee(emp);
		if (res) {
			logger.info(emp + " Employee Updated Successfully");
			return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully!");
		}
		logger.error(emp + " Employee does not exist!");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee does not exist!");
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		boolean res = service.deleteById(id);
		if (res) {
			logger.info("Employee with id: " + id + " deleted successfully!");
			return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully!");
		}
		logger.error("Employee with id: " + id + " not found!");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee does not exist!");
	}

	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
		List<EmployeeModel> res = service.getAllEmployees();
		if (res == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("getbycity/{city}")
	public ResponseEntity<List<EmployeeModel>> getByCity(@PathVariable String city) {
		List<EmployeeModel> res = service.getByCity(city);
		if (res == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("getbytype/{type}")
	public ResponseEntity<List<EmployeeModel>> getByType(@PathVariable String type) {
		List<EmployeeModel> res = service.getByType(type);
		if (res == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("getbycityandtype/{city}/{type}")
	public ResponseEntity<List<EmployeeModel>> getByCityAndType(@PathVariable String city, @PathVariable String type) {
		List<EmployeeModel> res = service.getByCityAndType(city, type);
		if (res == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("getbyid/{id}")
	public ResponseEntity<EmployeeModel> getById(@PathVariable Integer id) {
		EmployeeModel res = service.getById(id);
		if (res == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

}
