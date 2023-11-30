package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
        //return empList;
    }

    public Employee getEmployee(int id){

//        for (Employee emp : empList) {
//            if (emp.getEmpID() == id) {
//                return emp;
//            }
//        }
//        return null;
//        return empList.stream().filter(
//                e -> (e.getEmpId() == id)).findFirst().get();
        //Employee byId = employeeRepo.getReferenceById(id);
//        List<Integer> ids = new ArrayList<>();
//        ids.add(id);
//        return employeeRepo.findAllById(ids).get(0);
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));

    }

    public void addEmployee(Employee employee) {
        //empList.add(employee);
        employeeRepo.save(employee);
    }

    public void updateEmployee(Employee employee) {

//        for (Employee e : empList)
//        {
//            if (e.getEmpId() == employee.getEmpId())
//            {
//                e.setEmpName(employee.getEmpName());
//                e.setEmpCity(employee.getEmpCity());
//            }
//        }
        employeeRepo.save(employee);

    }

    public void deleteEmployee(int id) {
//        ArrayList<Employee> tempEmpList = new ArrayList<>();
//        for (Employee e : empList)
//        {
//            if (e.getEmpId() == id)
//            {
//                continue;
//            }
//            tempEmpList.add(e);
//        }
//        empList = tempEmpList;
        employeeRepo.delete(employeeRepo.getReferenceById(id));
    }
}
