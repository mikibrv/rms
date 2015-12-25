package com.miki.rms.domain.shared.validators;

import com.miki.rms.domain.model.user.exceptions.InvalidReferenceException;
import com.miki.rms.domain.shared.DomainException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by miki on 25.12.2015.
 */
public class NullValidatorTest {

    Validator<Object> nullValidator = ValidatorProvider.getInstance().nullValidator();

    @Test
    public void testValidNullValidator() {
        assertTrue(nullValidator.validate(" "));
    }

    @Test
    public void testInvalidNullValidator() {
        assertFalse(nullValidator.validate(null));
    }

    @Test(expected = DomainException.class)
    public void testErrorIsThrownForNull() {
        final String arg = "userEntity";
        try {
            nullValidator.raiseExceptionIfInvalid(null, InvalidReferenceException.class,
                    InvalidReferenceException.DEFAULT_MESSAGE, arg);

        } catch (DomainException domainException) {
            assertTrue(domainException.getMessage().contains(arg));
            throw domainException;
        }
    }

}
