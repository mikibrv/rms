package com.miki.rms.domain.model.user.exceptions;

import com.miki.rms.domain.shared.DomainException;

/**
 * Aka NPE for my domain
 * Created by miki on 25.12.2015.
 */
public class InvalidReferenceException extends DomainException {

    public static final String DEFAULT_MESSAGE = "Invalid reference for: {0} you have provided";

    public InvalidReferenceException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidReferenceException(String message, Exception originalException) {
        super(message, originalException);
    }

    public InvalidReferenceException(String message, Exception originalException, String... params) {
        super(message, originalException, params);
    }

    public InvalidReferenceException(String message, String... params) {
        super(message, params);
    }

    public InvalidReferenceException(String message) {
        super(message);
    }
}
