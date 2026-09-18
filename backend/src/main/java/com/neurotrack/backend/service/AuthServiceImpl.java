package com.neurotrack.backend.service;

import com.neurotrack.backend.dto.LoginDTO;
import com.neurotrack.backend.dto.RegisterDTO;
import com.neurotrack.backend.entity.User;
import com.neurotrack.backend.repository.UserRepository;
import com.neurotrack.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public String register(RegisterDTO dto) {

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);

        return "Registered Successfully";
    }

    @Override
    public String login(LoginDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login Successful";
    }
}