package com.example.controller;

import com.example.employee.api.EmployeesApi;
import com.example.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController implements EmployeesApi {

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {
        return EmployeesApi.super.createEmployee(employee);
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Integer id) {
        return EmployeesApi.super.deleteEmployee(id);
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return EmployeesApi.super.getAllEmployees();
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Integer id) {
        return EmployeesApi.super.getEmployeeById(id);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Integer id, Employee employee) {
        return EmployeesApi.super.updateEmployee(id, employee);
    }
}
