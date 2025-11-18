package org.example.hr_employeemanagement.modules.auth.controller;


import jakarta.validation.Valid;
import org.example.hr_employeemanagement.modules.auth.dto.RegisterRequest;
import org.example.hr_employeemanagement.modules.auth.dto.LoginRequest;
import org.example.hr_employeemanagement.modules.auth.dto.JwtResponse;
import org.example.hr_employeemanagement.modules.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")

    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")

    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
