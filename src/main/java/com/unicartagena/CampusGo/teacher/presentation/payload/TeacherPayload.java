package com.unicartagena.CampusGo.teacher.presentation.payload;

import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthCreateRoleRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TeacherPayload (@NotBlank String username,
                              @NotBlank String dni,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotBlank String phone
                              ){
    
}
