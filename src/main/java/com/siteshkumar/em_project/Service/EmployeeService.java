package com.siteshkumar.em_project.Service;

import java.util.List;
import com.siteshkumar.em_project.Model.Employee;

public interface EmployeeService {
    public String createEmployee(Employee employee);
    List<Employee> readEmployees();
    Employee readEmployeeById(Long id);
    String updateEmployee(Long id, Employee employee);
    boolean deleteEmployee(Long id);
}
