package org.example.hr_employeemanagement.modules.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Employee creation/update request")
public class EmployeeRequest {

    @NotBlank
    @Schema(description = "Employee full name", example = "John Doe")
    private String name;

    @Schema(description = "Job position", example = "Software Engineer")
    private String position;

    @Schema(description = "Department", example = "IT")
    private String department;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
