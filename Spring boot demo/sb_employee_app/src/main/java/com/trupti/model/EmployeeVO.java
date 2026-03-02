package com.trupti.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Employee")
public record EmployeeVO(Integer empId, String empName, String empCity, String type) {
}
