package com.miki.rms.domain.shared.validators;

import com.miki.rms.domain.AbstractDomainTest;
import com.miki.rms.domain.model.user.exceptions.InvalidEmailException;
import com.miki.rms.domain.shared.DomainException;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by miki on 25.12.2015.
 */
public class EmailValidatorTest extends AbstractDomainTest {


    private final String VALID_EMAIL = "test@test.com";
    private final String INVALID_EMAIL = "test@tes";

    @Test
    public void validEmailIsValid() {
        assertTrue(ValidatorProvider.getInstance().emailValidator().validate(VALID_EMAIL));
    }

    @Test
    public void invalidEmailIsInvalid() {
        assertFalse(ValidatorProvider.getInstance().emailValidator().validate(INVALID_EMAIL));
    }


    @Test
    public void validEmailShouldNotThrowException() {
        ValidatorProvider.getInstance().emailValidator().raiseExceptionIfInvalid(VALID_EMAIL,
                InvalidEmailException.class, InvalidEmailException.DEFAULT_MESSAGE, VALID_EMAIL);
    }

    @Test(expected = InvalidEmailException.class)
    public void invalidEmailShouldThrowException() {
        try {
            ValidatorProvider.getInstance().emailValidator().raiseExceptionIfInvalid(INVALID_EMAIL,
                    InvalidEmailException.class, InvalidEmailException.DEFAULT_MESSAGE, INVALID_EMAIL);
        } catch (DomainException domainException) {
            assertTrue(domainException.getMessage().contains(INVALID_EMAIL));
            throw domainException;
        }
    }


}
