package com.example.springaopdemo.controller;

import com.example.springaopdemo.annotation.AuditLog;
import com.example.springaopdemo.dto.Employee;
import com.example.springaopdemo.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService service;
    @RequestMapping("/hello")
    public String greet() {
        return  service.greetPeopleWithMessage("Hello", 10);
    }

    @RequestMapping("/employee")
    public Employee employee() {
        return  service.printEmployee();
    }
}
