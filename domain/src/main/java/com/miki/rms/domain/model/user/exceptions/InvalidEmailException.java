package com.miki.rms.domain.model.user.exceptions;

import com.miki.rms.domain.shared.DomainException;

/** Created by miki on 25.12.2015. */
public class InvalidEmailException extends DomainException {

    public static final String DEFAULT_MESSAGE = "An invalid email {0} was provided";

    public InvalidEmailException() {
        this(DEFAULT_MESSAGE);
    }

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException(String message, String... params) {
        super(message, params);
    }
}
