package com.miki.rms.domain.shared;

/** Enables class to be decorated; Created by mikibrv on 07/02/16. */
public interface Decorable<T> {

    /** Decorate with a specific decorator;
     * 
     * @param toBeDecorated */
    T decorate(final T toBeDecorated);

}
