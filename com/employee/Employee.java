package com.employee;

import java.io.Serializable;

public class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    private String employeeNumber;
    private String employeeName;
    private double netSalary;


    public Employee(){}
    public Employee(String employeeNumber, String employeeName, double netSalary){
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.netSalary = netSalary;
    }

    @Override
    public String toString() {
        return "The employee is : " + "Employee number - " + employeeNumber + " , Employee name - " + employeeName + " , Employee net salary - " + netSalary;
    }
}
