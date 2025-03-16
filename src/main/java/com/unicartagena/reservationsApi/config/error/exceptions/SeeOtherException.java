package com.unicartagena.reservationsApi.config.error.exceptions;


public class SeeOtherException extends RuntimeException {

    public SeeOtherException(String message) {
        super(message);
    }

    public SeeOtherException(String message, Throwable cause) {
        super(message, cause);
    }
}