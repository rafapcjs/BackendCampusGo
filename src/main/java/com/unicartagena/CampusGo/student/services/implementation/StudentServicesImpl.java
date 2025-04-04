package com.unicartagena.CampusGo.student.services.implementation;

import com.unicartagena.CampusGo.security.auth.factory.AuthUserMapper;
import com.unicartagena.CampusGo.security.auth.persistencie.repositories.IRoleRepository;
import com.unicartagena.CampusGo.security.auth.persistencie.rol.RoleEnum;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.security.utils.jwt.JwtTokenProvider;
import com.unicartagena.CampusGo.student.persistencie.entity.Student;
import com.unicartagena.CampusGo.student.persistencie.repository.IStudentRepository;
import com.unicartagena.CampusGo.student.presentation.payload.StudentPayload;
import com.unicartagena.CampusGo.student.services.interfaces.IStudentServices;
import com.unicartagena.CampusGo.teacher.persistencie.entity.Teacher;
import com.unicartagena.CampusGo.teacher.persistencie.repository.ITeacherRepository;
import com.unicartagena.CampusGo.teacher.presentation.payload.TeacherPayload;
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
public class StudentServicesImpl  implements IStudentServices {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IStudentRepository iStudentRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserMapper authUserMapper;

    @Override
    public AuthResponse register(StudentPayload request) {
        var teacherRole = roleRepository.findByRoleEnum(RoleEnum.STUDENT)
                .orElseThrow(() -> new IllegalArgumentException("Rol TEACHER no encontrado"));

        Set roles = Set.of(teacherRole);

        UserEntity user = authUserMapper.toUserEntity(request, roles, passwordEncoder);
        userRepository.save(user);

        Student student = Student.builder()
                .user(user)
                .build();

        iStudentRepository.save(student);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, null, authUserMapper.mapRoles(user.getRoles()));

        String accessToken = jwtTokenProvider.createAccessToken(authentication);

        return new AuthResponse(user.getUsername(), "Docente registrado correctamente", accessToken, true);
    }
}