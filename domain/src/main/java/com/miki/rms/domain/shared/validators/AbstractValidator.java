package com.miki.rms.domain.shared.validators;

import com.miki.rms.domain.shared.DomainException;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by miki on 25.12.2015.
 */
public abstract class AbstractValidator<T> implements Validator<T> {


    public void raiseExceptionIfInvalid(T toValidate, Class<? extends DomainException> exception,
                                        String... args) {
        if (!this.validate(toValidate)) {
            this.throwDomainException(exception, args);
        }
    }


    /**
     * Returns a new instance of the exception class with specific args;
     * Based on the DomainException.class
     *
     * @param exceptionClass
     * @param args
     */
    protected void throwDomainException(Class<? extends DomainException> exceptionClass,
                                        String... args) throws DomainException {
        try {
            throwExceptionWithMessageAndArgs(exceptionClass, args);
            throwExceptionWithMessage(exceptionClass, args);
            throwEmptyException(exceptionClass);

        } catch (InstantiationException | IllegalAccessException
                | InvocationTargetException | NoSuchMethodException e) {
            //is java bad or what?
            throw new DomainException.GenericDomainException(e.getMessage(), e);
        }
    }

    /**
     * Returns a new instance of the exception class with specific args;
     * Based on the DomainException.class
     *
     * @param exceptionClass
     * @param args
     */
    protected void throwExceptionWithMessageAndArgs(Class<? extends DomainException> exceptionClass,
                                                    String... args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (args.length > 1) {
            throw exceptionClass.getConstructor(String.class, String[].class).newInstance(args[0],
                    Arrays.copyOfRange(args, 1, args.length));
        }
    }

    /**
     * Returns a new instance of the exception class with specific args;
     * Based on the DomainException.class
     *
     * @param exceptionClass
     * @param args
     */
    protected void throwExceptionWithMessage(Class<? extends DomainException> exceptionClass,
                                             String... args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (args.length == 1) {
            throw exceptionClass.getConstructor(String.class).newInstance(args[0]);
        }
    }

    /**
     * Returns a new instance of the exception class with specific args;
     * Based on the DomainException.class
     *
     * @param exceptionClass
     */
    protected void throwEmptyException(Class<? extends DomainException> exceptionClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        throw exceptionClass.getConstructor().newInstance();
    }


}
