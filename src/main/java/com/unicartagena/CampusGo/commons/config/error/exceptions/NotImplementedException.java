package com.unicartagena.CampusGo.commons.config.error.exceptions;




public class NotImplementedException extends RuntimeException {

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }
}