package com.unicartagena.CampusGo.student.presentation.payload;


import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthCreateRoleRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record StudentPayload (@NotBlank String username,
                              @NotBlank String dni,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotBlank String phone
){

}
