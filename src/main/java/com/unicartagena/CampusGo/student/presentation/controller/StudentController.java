package com.unicartagena.CampusGo.student.presentation.controller;

import com.unicartagena.CampusGo.commons.constants.ConsultationPaths;
import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.student.presentation.payload.StudentPayload;
import com.unicartagena.CampusGo.student.services.interfaces.IStudentServices;
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
@RequestMapping(ConsultationPaths.REGISTER)
@RequiredArgsConstructor
@Tag(name = "Auth")

public class StudentController {


    private final IStudentServices iStudentServices;

    @Operation(summary = "Registrar un nuevo estudiante",
            description = "Registra un nuevo estudiante en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Docente registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Error en la solicitud de registro")
    })
    @PostMapping("/student")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody StudentPayload studentPayload) {
        AuthResponse response = iStudentServices.register(studentPayload);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }}