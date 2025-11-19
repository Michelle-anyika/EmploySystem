package org.example.hr_employeemanagement.modules.auth.service;

import org.example.hr_employeemanagement.exception.ResourceNotFoundException;
import org.example.hr_employeemanagement.modules.auth.model.Role;
import org.example.hr_employeemanagement.modules.auth.model.User;
import org.example.hr_employeemanagement.modules.auth.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    public void promoteToAdmin(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setRole(Role.ROLE_ADMIN);
        userRepository.save(user);
    }
}