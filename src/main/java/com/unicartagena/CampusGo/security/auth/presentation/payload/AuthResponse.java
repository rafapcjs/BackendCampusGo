package com.unicartagena.CampusGo.security.auth.presentation.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "status", "accessToken"})
public record AuthResponse(
        String username,
        String message,
        String accessToken,
        Boolean status
)
{
}