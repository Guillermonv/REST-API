package com.api.apros.service.validator.exceptions;


import com.api.apros.util.SystemEvent;

public class ValidationException extends Exception {

    public ValidationException(SystemEvent message) {
        super(String.valueOf(message));
    }

}
