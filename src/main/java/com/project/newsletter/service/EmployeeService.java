package com.project.newsletter.service;

import com.project.newsletter.model.Employee;
import com.project.newsletter.model.Event;
import com.project.newsletter.repository.EmployeeRepository;
import com.project.newsletter.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EventRepository eventRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EventRepository eventRepository) {
        this.employeeRepository = employeeRepository;
        this.eventRepository = eventRepository;
    }

    public List<Employee> getAllEmployees() {
        log.info("getAllEmployees >> ");
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        if (employee != null) {
            log.info("addEmployee >> {}", employee);
            return employeeRepository.save(employee);
        }
        else {
            log.error("addEmployee >> employee is null");
            return null;
        }
    }

    public Optional<Employee> getEmployeeByEmail(String emailId) {
        return employeeRepository.findByEmailId(emailId);
    }

    public Optional<Employee> getEmployeeById(Long empId) {
        return employeeRepository.findById(empId);
    }

    public Employee employeeSubscribeToEvent(Employee employee, Long eventId) throws Exception {
        Optional<Event> event = eventRepository.findById(eventId);

        if (event.isEmpty())
            throw new Exception("Event not found!");

        else {
            Set<Event> events = employee.getEvents();
            events.add(event.get());
            employee.setEvents(events);
            return employeeRepository.save(employee);
        }
    }
}
