package com.example.employee.controller;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.service.EmployeeService;
import com.example.employee.utils.GenericApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public GenericApiResponse<List<EmployeeEntity>> getAllEmployees() {

        List<EmployeeEntity> employeeEntities =  employeeService.getAllEmployees();
        GenericApiResponse<List<EmployeeEntity>> employeeResponse = new GenericApiResponse<List<EmployeeEntity>>();
        employeeResponse.setData(employeeEntities);
        employeeResponse.setSuccessful(true);
        employeeResponse.setMessage("Employees fetched successfully");
        employeeResponse.setStatusCode(200);
        return employeeResponse;
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable UUID id, @RequestBody EmployeeEntity employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return "EmployeeEntity deleted successfully";
    }
}


