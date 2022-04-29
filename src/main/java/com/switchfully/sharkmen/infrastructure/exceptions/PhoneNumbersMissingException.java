package com.switchfully.sharkmen.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PhoneNumbersMissingException extends RuntimeException {
    public PhoneNumbersMissingException(String message) {
        super(message);
    }
}
