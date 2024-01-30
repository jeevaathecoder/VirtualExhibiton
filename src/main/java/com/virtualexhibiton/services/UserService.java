package com.virtualexhibiton.services;

import com.virtualexhibiton.model.User;
import com.virtualexhibiton.model.UserRole;
import com.virtualexhibiton.repository.UserRepository;
import com.virtualexhibiton.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(SignupRequest signUpRequest) {
        String email = signUpRequest.getEmail();

        // Check if the username or email is already taken
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Username is already taken!");
        }

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email is already in use!");
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                email,
                passwordEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getMobile(),
                signUpRequest.getProfile()
        );

        Set<UserRole> roles = signUpRequest.getRoles().stream()
                .map(UserRole::valueOf)
                .collect(Collectors.toSet());

        user.setRoles(roles);
        userRepository.save(user);
    }
}
