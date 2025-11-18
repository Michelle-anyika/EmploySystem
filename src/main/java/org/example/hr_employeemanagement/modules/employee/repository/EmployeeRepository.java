package org.example.hr_employeemanagement.modules.employee.repository;

import org.example.hr_employeemanagement.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
