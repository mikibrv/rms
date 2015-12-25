package com.miki.rms.domain.shared.validators;

/**
 * Created by miki on 25.12.2015.
 */
public class NullValidator extends AbstractValidator<Object> implements Validator<Object> {

    public boolean validate(final Object toValidate) {
        return toValidate != null;
    }

}
