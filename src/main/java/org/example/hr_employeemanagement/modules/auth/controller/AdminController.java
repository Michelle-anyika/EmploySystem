package org.example.hr_employeemanagement.modules.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.hr_employeemanagement.modules.auth.model.User;
import org.example.hr_employeemanagement.modules.auth.service.AdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin Management", description = "Admin-only user management operations")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    @Operation(summary = "Get all users", description = "Admin can view all registered users")
    public ResponseEntity<Page<User>> getAllUsers(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(adminService.getAllUsers(pageable));
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Delete user", description = "Admin can delete any user")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/users/{id}/promote")
    @Operation(summary = "Promote user to admin", description = "Admin can promote users to admin role")
    public ResponseEntity<String> promoteToAdmin(@PathVariable Long id) {
        adminService.promoteToAdmin(id);
        return ResponseEntity.ok("User promoted to admin successfully");
    }
}