package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
    }
}
