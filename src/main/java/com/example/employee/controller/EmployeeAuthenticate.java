package com.example.employee.controller;

import com.example.employee.utils.GenericApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class EmployeeAuthenticate {
    @GetMapping
    public GenericApiResponse<String> authenticate(HttpServletRequest request, HttpServletResponse response) {
          GenericApiResponse<String> data = new GenericApiResponse<>();
          data.setSuccessful(true);
          data.setMessage("Employee authenticated successfully");
          data.setStatusCode(200);
          return data;
    }
}
