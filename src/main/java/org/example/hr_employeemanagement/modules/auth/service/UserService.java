package org.example.hr_employeemanagement.modules.auth.service;



import org.example.hr_employeemanagement.exception.BadRequestException;
import org.example.hr_employeemanagement.modules.auth.dto.LoginRequest;
import org.example.hr_employeemanagement.modules.auth.dto.RegisterRequest;
import org.example.hr_employeemanagement.modules.auth.dto.JwtResponse;
import org.example.hr_employeemanagement.modules.auth.model.Role;
import org.example.hr_employeemanagement.modules.auth.model.User;
import org.example.hr_employeemanagement.modules.auth.repository.UserRepository;
import org.example.hr_employeemanagement.security.JwtTokenUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public String register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BadRequestException("Username is already taken!");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email is already taken!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);

        userRepository.save(user);
        return "User registered successfully.";
    }


    public JwtResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadRequestException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = jwtTokenUtil.generateToken(user.getUsername());
        return new JwtResponse(token);
    }


}
