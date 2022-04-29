package com.switchfully.sharkmen.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

public class IllegalFormatForEmailException extends ResponseStatusException {
    public IllegalFormatForEmailException() {
        super(HttpStatus.BAD_REQUEST,"Please provide a correct E-mail address");
    }
}
