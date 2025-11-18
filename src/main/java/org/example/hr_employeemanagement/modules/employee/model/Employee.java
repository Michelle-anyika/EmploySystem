package org.example.hr_employeemanagement.modules.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Employee entity")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Employee ID", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Employee full name", example = "John Doe")
    private String name;

    @Schema(description = "Job position", example = "Software Engineer")
    private String position;

    @Schema(description = "Department", example = "IT")
    private String department;

    @Schema(description = "Date when employee was hired", example = "2024-01-15")
    private LocalDate hireDate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
}
