package com.unicartagena.CampusGo.teacher.services.implementation;

import com.unicartagena.CampusGo.security.auth.factory.AuthUserMapper;
import com.unicartagena.CampusGo.security.auth.persistencie.repositories.IRoleRepository;
import com.unicartagena.CampusGo.security.auth.persistencie.rol.RoleEnum;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.security.utils.jwt.JwtTokenProvider;
import com.unicartagena.CampusGo.teacher.persistencie.entity.Teacher;
import com.unicartagena.CampusGo.teacher.persistencie.repository.ITeacherRepository;
import com.unicartagena.CampusGo.teacher.presentation.payload.TeacherPayload;
import com.unicartagena.CampusGo.teacher.services.interfaces.ITeacherServices;
import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import com.unicartagena.CampusGo.user.persistencie.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherServicesImpl  implements ITeacherServices {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final ITeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserMapper authUserMapper;

    @Override
    public AuthResponse register(TeacherPayload request) {
        var teacherRole = roleRepository.findByRoleEnum(RoleEnum.TEACHER)
                .orElseThrow(() -> new IllegalArgumentException("Rol TEACHER no encontrado"));

        Set roles = Set.of(teacherRole);

        UserEntity user = authUserMapper.toUserEntity(request, roles, passwordEncoder);
        userRepository.save(user);

        Teacher teacher = Teacher.builder()
                .user(user)
                .build();

        teacherRepository.save(teacher);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, null, authUserMapper.mapRoles(user.getRoles()));

        String accessToken = jwtTokenProvider.createAccessToken(authentication);

        return new AuthResponse(user.getUsername(), "Docente registrado correctamente", accessToken, true);
    }
}