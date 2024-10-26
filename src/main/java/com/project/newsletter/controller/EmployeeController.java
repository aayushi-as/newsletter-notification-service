package com.project.newsletter.controller;

import com.project.newsletter.exception.DuplicateEmployeeException;
import com.project.newsletter.model.Employee;
import com.project.newsletter.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllEmployees() {
        log.info("getAllEmployees >>");
        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee) {
        log.info("addEmployee >>");
        Optional<Employee> existingEmployee = employeeService.getEmployeeByEmail(employee.getEmailId());

        if (existingEmployee.isPresent()) {
            throw new DuplicateEmployeeException("Employee already exists");
        }

        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PostMapping("/{empId}/subscribe/{eventId}")
    public ResponseEntity<?> subscribe(@PathVariable Long empId, @PathVariable Long eventId) throws Exception {
        log.info("{} subscribe to {}", empId, eventId);
        Optional<Employee> employee = employeeService.getEmployeeById(empId);

        if (employee.isEmpty())
            throw new UsernameNotFoundException("Employee with this employee id " + empId + "does not exist!");
        else {
            Employee employeeSubscribedEvent = employeeService.employeeSubscribeToEvent(employee.get(), eventId);
            return ResponseEntity.status(HttpStatus.OK).body(employeeSubscribedEvent);
        }
    }

}
