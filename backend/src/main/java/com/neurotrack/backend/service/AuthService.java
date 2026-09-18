package com.neurotrack.backend.service;

import com.neurotrack.backend.dto.LoginDTO;
import com.neurotrack.backend.dto.RegisterDTO;

public interface AuthService {

    String register(RegisterDTO dto);

    String login(LoginDTO dto);

}