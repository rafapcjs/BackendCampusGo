package com.unicartagena.CampusGo.user.presentation.controller;


import com.unicartagena.CampusGo.commons.constants.ConsultationPaths;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthCreateUserRequest;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthLoginRequest;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.security.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Auth")
@RequiredArgsConstructor
@RequestMapping(ConsultationPaths.AUTH)
public class AuthController {


    private final AuthService authService;

    @Operation(summary = "Registrar un nuevo usuario",
            description = "Registra un nuevo usuario en el sistema. \n\n**Requiere rol ADMIN**")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de registro")
    })
    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthCreateUserRequest userRequest) {
        return new ResponseEntity<>(this.authService.register(userRequest), HttpStatus.CREATED);
    }


    @Operation(
            summary = "Iniciar sesión de usuario",
            description = "Permite a un usuario iniciar sesión en el sistema y obtener un token JWT.\n\n**Acceso público**"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login exitoso, token JWT generado"),
            @ApiResponse(responseCode = "400", description = "Credenciales inválidas o error en la solicitud"),
            @ApiResponse(responseCode = "401", description = "No autorizado, credenciales incorrectas")
    })
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest) {
        return new ResponseEntity<>(this.authService.login(userRequest), HttpStatus.OK);
    }
}