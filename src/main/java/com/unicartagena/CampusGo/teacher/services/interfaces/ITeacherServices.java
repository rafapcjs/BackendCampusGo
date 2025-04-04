package com.unicartagena.CampusGo.teacher.services.interfaces;

import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.teacher.presentation.payload.TeacherPayload;

public interface ITeacherServices {
    AuthResponse register(TeacherPayload request);

}
