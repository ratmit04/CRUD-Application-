package com.example.em_project;

import java.util.List;

public interface EmployeeService {
   String createEmployee(Employee employee);
    Object readEmployee(Long id);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    boolean deleteEmployees();
    String updateEmployee(Long id ,Employee employee);

}
