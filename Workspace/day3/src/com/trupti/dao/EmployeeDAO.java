package com.trupti.dao;

import com.trupti.model.Employee;
import java.io.*;

public class EmployeeDAO {

    private static final String FILE_PATH = "employees.txt";

    public void addEmployee(Employee... emps) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (Employee emp : emps) {
                if (emp != null) {
                    bw.write(emp.getEmpId() + "," +
                             emp.getEmpName() + "," +
                             emp.getEmpCity());
                    bw.flush();
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public Employee[] getEmployees() {
        int count = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee[] employees = new Employee[count];
        int index = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String city = data[2];

                employees[index++] = new Employee(id, name, city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }


    public Employee getEmployeeById(int empId) {
        Employee[] employees = getEmployees();

        for (Employee e : employees) {
            if (e.getEmpId() == empId) {
                return e;
            }
        }
        return null;
    }

  
    public boolean getId(int empId) {
        return getEmployeeById(empId) != null;
    }


    public void updateEmployee(int empId, int newEmpId, String empName, String empCity) {
        Employee[] employees = getEmployees();

        for (Employee e : employees) {
            if (e.getEmpId() == empId) {
                e.setEmpId(newEmpId);
                e.setEmpName(empName);
                e.setEmpCity(empCity);
            }
        }

        writeAllEmployees(employees);
    }


    public void deleteEmployee(int empId) {
        Employee[] employees = getEmployees();
        int count = 0;


        for (Employee e : employees) {
            if (e.getEmpId() != empId) {
                count++;
            }
        }

        Employee[] updated = new Employee[count];
        int index = 0;

        for (Employee e : employees) {
            if (e.getEmpId() != empId) {
                updated[index++] = e;
            }
        }

        writeAllEmployees(updated);
    }


    private void writeAllEmployees(Employee[] employees) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Employee emp : employees) {
                bw.write(emp.getEmpId() + "," +
                         emp.getEmpName() + "," +
                         emp.getEmpCity());
                bw.flush();
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
