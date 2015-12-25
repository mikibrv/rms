package com.miki.rms.domain.shared.validators;

import com.miki.rms.domain.shared.DomainException;

/**
 * Created by miki on 25.12.2015.
 */
public interface Validator<T> {

    boolean validate(final T toValidate);

    void raiseExceptionIfInvalid(final T toValidate, final Class<? extends DomainException> exception,
                                 String... args);

}
