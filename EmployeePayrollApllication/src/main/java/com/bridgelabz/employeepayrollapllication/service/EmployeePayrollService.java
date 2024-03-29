package com.bridgelabz.employeepayrollapllication.service;

import com.bridgelabz.employeepayrollapllication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapllication.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData>  getEmployeePayrollData(){
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId){
        return employeePayrollDataList.get(empId-1);
    }

    @Override
    public EmployeePayrollData EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return null;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size()+1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO){
        for (EmployeePayrollData employeePayrollData: employeePayrollDataList) {
            if (employeePayrollData.getEmployeeId() == empId){
                employeePayrollData.setEmployeeName(employeePayrollDTO.name);
                employeePayrollData.setEmployeeSalary(employeePayrollDTO.salary);
                return employeePayrollData;
            }
        }
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(int empId){
        employeePayrollDataList.remove(empId-1);
    }
}