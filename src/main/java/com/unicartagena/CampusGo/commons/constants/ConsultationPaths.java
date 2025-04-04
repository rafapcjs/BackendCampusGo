package com.unicartagena.CampusGo.commons.constants;


public interface ConsultationPaths {
    String BASE_API = "/api/v1";
    String AUTH = BASE_API + "/auth";

    // Authentication paths
    String LOGIN = AUTH + "/login";
    String REGISTER = AUTH + "/register";

    // Authentication Google paths
    String GOOGLE = AUTH + "/google";

    // User Paths
    String USER = BASE_API + "/user";
}
