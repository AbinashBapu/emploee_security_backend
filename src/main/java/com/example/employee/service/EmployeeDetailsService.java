package com.example.employee.service;

import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findByEmailAddress(username);
        if(optionalEmployeeEntity.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }
        EmployeeEntity emp = optionalEmployeeEntity.get();
        return User.builder().username(emp.getEmailAddress()).password(emp.getPassword()).authorities(emp.getAuthorities().split(";")).build();
    }
}
