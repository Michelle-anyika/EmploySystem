package org.example.hr_employeemanagement.config;

import org.example.hr_employeemanagement.modules.auth.model.Role;
import org.example.hr_employeemanagement.modules.auth.model.User;
import org.example.hr_employeemanagement.modules.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Value("${SUPER_ADMIN_USERNAME}")
    private String superAdminUsername;
    
    @Value("${SUPER_ADMIN_PASSWORD}")
    private String superAdminPassword;
    
    @Value("${SUPER_ADMIN_EMAIL}")
    private String superAdminEmail;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create super admin if not exists
        if (!userRepository.existsByUsername(superAdminUsername)) {
            User superAdmin = new User();
            superAdmin.setUsername(superAdminUsername);
            superAdmin.setEmail(superAdminEmail);
            superAdmin.setPassword(passwordEncoder.encode(superAdminPassword));
            superAdmin.setRole(Role.ROLE_ADMIN);
            
            userRepository.save(superAdmin);
            System.out.println("✅ Super Admin created: username=" + superAdminUsername);
        }
    }
}