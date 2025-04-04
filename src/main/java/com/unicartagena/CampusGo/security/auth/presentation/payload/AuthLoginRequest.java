package com.unicartagena.CampusGo.security.auth.presentation.payload;


import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
        @NotBlank String email,
        @NotBlank String password
) {
}