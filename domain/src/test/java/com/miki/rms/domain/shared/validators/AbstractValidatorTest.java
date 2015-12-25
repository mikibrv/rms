package com.miki.rms.domain.shared.validators;

import com.miki.rms.domain.shared.DomainException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Checks for correct exceptions being thrown in validators
 * Created by miki on 25.12.2015.
 */
public class AbstractValidatorTest {

    /**
     * Mocked validator that will return always true;
     */
    private final AbstractValidator<String> trueValidator =
            new AbstractValidator<String>() {
                @Override
                public boolean validate(String toValidate) {
                    return true;
                }
            };

    /**
     * Mocked validator that will return always false;
     */
    private final AbstractValidator<String> falseValidator =
            new AbstractValidator<String>() {
                @Override
                public boolean validate(String toValidate) {
                    return false;
                }
            };

    @Test(expected = DomainException.GenericDomainException.class)
    public void testEmptyExceptionMessage() {
        try {
            trueValidator.throwDomainException(DomainException.GenericDomainException.class);
        } catch (DomainException domainException) {
            assertEquals(DomainException.DEFAULT_MESSAGE, domainException.getMessage());
            throw domainException;
        }
    }

    @Test(expected = DomainException.GenericDomainException.class)
    public void testOneMessageException() {
        final String message = "An exception was raised test";
        try {
            trueValidator.throwDomainException(DomainException.GenericDomainException.class, message);
        } catch (DomainException domainException) {
            assertEquals(message, domainException.getMessage());
            throw domainException;
        }
    }

    @Test(expected = DomainException.GenericDomainException.class)
    public void testMultipleArgsException() {
        final String message = "An exception was raised with args {0}, {1} ";
        final String arg1 = "arg1";
        final String arg2 = "arg2";
        try {
            trueValidator.throwDomainException(DomainException.GenericDomainException.class, message,
                    arg1, arg2);
        } catch (DomainException domainException) {
            assertNotNull(domainException.getMessage());
            assertTrue(domainException.getMessage().contains(arg1));
            assertTrue(domainException.getMessage().contains(arg2));
            throw domainException;
        }
    }


}
