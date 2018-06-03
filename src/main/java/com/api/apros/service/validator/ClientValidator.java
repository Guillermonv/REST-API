package com.api.apros.service.validator;

import org.springframework.stereotype.Component;

import com.api.apros.model.Client;
import com.api.apros.service.validator.exceptions.ValidationException;
import com.api.apros.util.SystemEvent;

@Component
public class ClientValidator {

    public void validateClient(Client client) throws ValidationException {
        if (client.getApellido() == null || client.getApellido().length() > 30) {
            throw new ValidationException(SystemEvent.INVALID_NOMBRE);
        }
        if (client.getApellido() == null || client.getApellido().length() > 30) {
            throw new ValidationException(SystemEvent.INVALID_APELLIDO);
        }
        if (client.getEdad() > 120 || client.getEdad() < 18) {
            throw new ValidationException(SystemEvent.INVALIDAD_EDAD);
        }
    }
}
