package com.bridgelabz.employeepayrollapllication.model;

import com.bridgelabz.employeepayrollapllication.dto.EmployeePayrollDTO;

public class EmployeePayrollData {
    private int employeeId;
    private String employeeName;
    private long employeeSalary;

    public EmployeePayrollData(){ }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.employeeName = employeePayrollDTO.name;
        this.employeeSalary = employeePayrollDTO.salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}

