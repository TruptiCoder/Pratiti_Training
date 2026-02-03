package com.trupti.collection;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee_set")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String firstName; 
   private String lastName;   
   private int salary;
   
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="emp_id")
   private Set<Certificate> certificates;
}
