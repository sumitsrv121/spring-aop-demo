package com.example.springaopdemo.service;

import com.example.springaopdemo.annotation.AuditLog;
import com.example.springaopdemo.dto.Employee;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private static int count = 0;

    @AuditLog
    public String greetPeopleWithMessage(String value, long id) {
        try {
            System.out.println("Count"+count);
            if (count % 2 == 0) {
                count++;
                throw new RuntimeException("Hello service threw exception");
            }
            return "Good Morning";
        } catch (Exception e) {
            System.out.println("There was some exception............");
            throw e;
        }
    }

    @AuditLog
    public Employee printEmployee() {
        try {
            System.out.println("Count"+count);
            if (count % 2 == 0) {
                count++;
                throw new RuntimeException("Hello service threw exception");
            }
            return new Employee(1, "Sumit");
        } catch (Exception e) {
            System.out.println("There was some exception............");
            throw e;
        }
    }
}
