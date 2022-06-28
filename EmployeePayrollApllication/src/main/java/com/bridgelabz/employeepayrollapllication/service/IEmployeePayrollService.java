package com.bridgelabz.employeepayrollapllication.service;

import com.bridgelabz.employeepayrollapllication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapllication.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
   List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}

