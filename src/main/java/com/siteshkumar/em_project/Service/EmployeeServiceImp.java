package com.siteshkumar.em_project.Service;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.siteshkumar.em_project.Model.EmpEntity;
import com.siteshkumar.em_project.Model.Employee;
import com.siteshkumar.em_project.Repository.EmpRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
    
    @Autowired
    private EmpRepository empRepository;

    @Override
    public String createEmployee(Employee employee) {

        // To store into the database we have to convert data from one class to another
        // Data Conversion from Employee class to EmpEntity Class
        EmpEntity empEntity = new EmpEntity();

        BeanUtils.copyProperties(employee, empEntity);

        empRepository.save(empEntity);
        return "Saved Successfully";
    }


    @Override
    public List<Employee> readEmployees(){

        // To get the date we have to again convert data from one class to another
        List<EmpEntity> employeesList = empRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for(EmpEntity empEntity : employeesList){

            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setName(empEntity.getName());
            emp.setEmail(empEntity.getEmail());
            emp.setPhone(empEntity.getPhone());

            employees.add(emp);
        }
        return employees;
    }


    @Override
    public Employee readEmployeeById(Long id) {

        EmpEntity empEntity = empRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(empEntity, employee);
        
        return employee;
    }  


    @Override
    public String updateEmployee(Long id, Employee employee) {

        EmpEntity existingEmployee = empRepository.findById(id).get();
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        empRepository.save(existingEmployee);
        return "Update Successfully";
    } 


    @Override
    public boolean deleteEmployee(Long id) {
        EmpEntity emp = empRepository.findById(id).get();
        empRepository.delete(emp);
        return true;
    } 
}
