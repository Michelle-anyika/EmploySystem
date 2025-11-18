package org.example.hr_employeemanagement.modules.employee.service;


import org.example.hr_employeemanagement.modules.employee.dto.EmployeeRequest;
import org.example.hr_employeemanagement.modules.employee.model.Employee;
import org.example.hr_employeemanagement.modules.employee.repository.EmployeeRepository;
import org.example.hr_employeemanagement.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setDepartment(request.getDepartment());
        employee.setHireDate(LocalDate.now());

        return employeeRepository.save(employee);
    }

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = getEmployee(id);

        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setDepartment(request.getDepartment());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployee(id);
        employeeRepository.delete(employee);
    }
}
