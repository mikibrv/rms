package com.miki.rms.domain.shared;

import java.text.MessageFormat;

/**
 * Created by miki on 13.12.2015.
 */
public abstract class DomainException extends RuntimeException {

    public static final String DEFAULT_MESSAGE = "A domain exception was raised";

    public DomainException() {
        super(DEFAULT_MESSAGE);
    }

    /**
     * @param message
     * @param originalException
     */
    public DomainException(String message, Exception originalException) {
        super(message, originalException);
    }

    /**
     * @param message
     * @param originalException
     * @param params
     */
    public DomainException(String message, Exception originalException, String... params) {
        this(MessageFormat.format(message, params), originalException);
    }

    /**
     * @param message
     * @param params
     */
    public DomainException(String message, String... params) {
        this(MessageFormat.format(message, params));
    }

    /**
     * @param message
     */
    public DomainException(String message) {
        super(message);
    }

    /**
     * A generic Domain exception, in case there is no specific one;
     */
    public static class GenericDomainException extends DomainException {

        public GenericDomainException() {
            super(DEFAULT_MESSAGE);
        }

        public GenericDomainException(String message, Exception originalException) {
            super(message, originalException);
        }

        public GenericDomainException(String message, Exception originalException, String... params) {
            super(message, originalException, params);
        }

        public GenericDomainException(String message, String... params) {
            super(message, params);
        }

        public GenericDomainException(String message) {
            super(message);
        }
    }
}

