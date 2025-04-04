package com.unicartagena.CampusGo.security.auth.service.sign_in;

import com.unicartagena.CampusGo.security.auth.factory.AuthUserMapper;
import com.unicartagena.CampusGo.security.auth.persistencie.repositories.IRoleRepository;
import com.unicartagena.CampusGo.security.auth.persistencie.rol.RoleEntity;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthCreateUserRequest;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.security.utils.jwt.JwtTokenProvider;
import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import com.unicartagena.CampusGo.user.persistencie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;


import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AuthRegisterService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserMapper authUserMapper;

    public AuthResponse register(AuthCreateUserRequest request) {
        // Obtener los roles del usuario
        Set<RoleEntity> roleEntities = roleRepository
                .findRoleEntitiesByRoleEnumIn(request.roleRequest().roleListName())
                .stream().collect(Collectors.toSet());

        if (roleEntities.isEmpty()) throw new IllegalArgumentException("Roles not found");

        // Mapear y guardar el usuario
        UserEntity user = authUserMapper.toUserEntity(request, roleEntities, passwordEncoder);
        userRepository.save(user);

        // Crear autenticación con roles
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, null, authUserMapper.mapRoles(user.getRoles()));

        // Generar Access Token
        String accessToken = jwtTokenProvider.createAccessToken(authentication);

        return new AuthResponse(user.getUsername(), "User created successfully", accessToken, true);
    }
}