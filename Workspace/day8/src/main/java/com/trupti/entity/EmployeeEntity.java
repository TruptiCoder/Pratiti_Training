package com.trupti.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
		@NamedQuery(name="getByCity", query="from EmployeeEntity where city=:city"),
		@NamedQuery(name="getByFname", query="from EmployeeEntity where fname=:fname")
})

//@NamedQuery(name="getByCity", query="from EmployeeEntity where city=:city")
public class EmployeeEntity {
	
	@Id
	private Integer id;
	private String fname;
	private String lname;
	private String city;
	
}
