package org.example.hr_employeemanagement.modules.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "User login request")
public class LoginRequest {

    @NotBlank
    @Schema(description = "Username", example = "john_doe")
    private String username;

    @NotBlank
    @Schema(description = "Password", example = "password123")
    private String password;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
