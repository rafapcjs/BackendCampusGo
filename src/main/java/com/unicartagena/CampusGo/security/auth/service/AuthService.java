package com.unicartagena.CampusGo.security.auth.service;

import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthCreateUserRequest;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthLoginRequest;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.security.auth.service.login.AuthLoginService;
import com.unicartagena.CampusGo.security.auth.service.sign_in.AuthRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRegisterService authRegisterService;
    private final AuthLoginService authLoginService;


    public AuthResponse register(AuthCreateUserRequest request) {
        return authRegisterService.register(request);
    }

    public AuthResponse login(AuthLoginRequest request) {
        return authLoginService.login(request);
    }




}