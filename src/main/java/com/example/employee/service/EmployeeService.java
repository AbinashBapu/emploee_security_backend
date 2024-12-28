package com.example.employee.service;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> getEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity updateEmployee(UUID id, EmployeeEntity employeeDetails) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeEntity not found"));

        employee.setEmailAddress(employeeDetails.getEmailAddress());
        employee.setPassword(employeeDetails.getPassword());
        employee.setActive(employeeDetails.isActive());
        employee.setAuthorities(employeeDetails.getAuthorities());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeEntity not found"));

        employeeRepository.delete(employee);
    }
}
