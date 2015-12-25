package com.miki.rms.domain.shared.validators;

/**
 * Created by miki on 25.12.2015.
 */
public class ValidatorProvider {

    protected static ValidatorProvider instance;

    protected Validator<String> emailValidator = new EmailValidator();

    protected Validator<Object> nullValidator = new NullValidator();

    public Validator<String> emailValidator() {
        return this.emailValidator;
    }

    public Validator<Object> nullValidator() {
        return this.nullValidator;
    }

    public void setInstance(ValidatorProvider instance) {
        instance = instance;
    }

    public static ValidatorProvider getInstance() {
        if (instance == null) {
            instance = new ValidatorProvider();
        }
        return instance;
    }
}
