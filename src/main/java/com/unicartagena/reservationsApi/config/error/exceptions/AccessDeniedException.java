package com.unicartagena.reservationsApi.config.error.exceptions;

public class AccessDeniedException extends java.nio.file.AccessDeniedException {

    public AccessDeniedException(String message) {
        super(message);
    }
}