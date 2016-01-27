package com.miki.rms.domain.model.user.exceptions;

import com.miki.rms.domain.shared.DomainException;

/** Created by miki on 13.12.2015. */
public class UserDomainException extends DomainException {

    public static final UserDomainException INVALID_EMAIL = new UserDomainException("Invalid email: {0}");

    public UserDomainException(String message, Exception originalException) {
        super(message, originalException);
    }

    public UserDomainException(String message, Exception originalException, String... params) {
        super(message, originalException, params);
    }

    public UserDomainException(String message, String... params) {
        super(message, params);
    }

    public UserDomainException(String message) {
        super(message);
    }
}
