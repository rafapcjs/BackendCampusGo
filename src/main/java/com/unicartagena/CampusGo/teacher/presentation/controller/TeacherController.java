package com.unicartagena.CampusGo.teacher.presentation.controller;


import com.unicartagena.CampusGo.commons.constants.ConsultationPaths;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.teacher.presentation.payload.TeacherPayload;
import com.unicartagena.CampusGo.teacher.services.interfaces.ITeacherServices;
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

@RequestMapping(ConsultationPaths.REGISTER)
@RequiredArgsConstructor
public class TeacherController {


    private final ITeacherServices iTeacherServices;

    @Operation(summary = "Registrar un nuevo docente",
            description = "Registra un nuevo docente en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Docente registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de registro")
    })
    @PostMapping("/teacher")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody TeacherPayload teacherRequest) {
        AuthResponse response = iTeacherServices.register(teacherRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }}