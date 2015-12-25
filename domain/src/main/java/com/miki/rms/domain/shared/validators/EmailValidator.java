package com.miki.rms.domain.shared.validators;


/**
 * Created by miki on 25.12.2015.
 */
public class EmailValidator extends AbstractValidator<String> implements Validator<String> {

    public boolean validate(final String toValidate) {
        return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(toValidate);
    }

}
