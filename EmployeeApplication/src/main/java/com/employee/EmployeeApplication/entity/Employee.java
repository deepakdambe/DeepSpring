package com.employee.EmployeeApplication.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empCity;
    @OneToOne
    Spouse spouse;
}
