package com.bridgelabz.employeepayrollapllication.controller;

import com.bridgelabz.employeepayrollapllication.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapllication.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapllication.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapllication.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService iEmployeePayrollService;

    @RequestMapping(value = {"", "/", "/get"}, method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> employeePayrollData = iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("get call success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId, ResponseDTO responseDTO){
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = iEmployeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO reasponseDTO = new ResponseDTO("get call for id success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

//    @GetMapping("/get")
//    public ResponseEntity<ResponseDTO> getEmployeePayrollDataUsingParam(@RequestParam ("empId") int empId){
//        EmployeePayrollData employeePayrollData = null;
//        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("Dinesh", 20000));
//        ResponseDTO responseDTO = new ResponseDTO("get call for id success", employeePayrollData);
//        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
//    }

    //Create Employee Details

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData = iEmployeePayrollService.createEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("created employee data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Update Employee Details

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollData = iEmployeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("updated employee payroll data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Delete Employee Details

    @DeleteMapping("delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        ResponseDTO responseDTO = new ResponseDTO("deleted successfully, deleted id:", empId);
        return new ResponseEntity<String>("Deleted employee payroll data", HttpStatus.OK);
    }
}
