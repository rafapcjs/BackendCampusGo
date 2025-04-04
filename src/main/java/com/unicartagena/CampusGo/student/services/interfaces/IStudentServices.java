package com.unicartagena.CampusGo.student.services.interfaces;

import com.unicartagena.CampusGo.security.auth.presentation.payload.AuthResponse;
import com.unicartagena.CampusGo.student.presentation.payload.StudentPayload;
import com.unicartagena.CampusGo.teacher.presentation.payload.TeacherPayload;

public interface IStudentServices {
    AuthResponse register(StudentPayload request);
}
