package com.miki.rms.domain.shared;

/**
 * Created by miki on 26.12.2015.
 */
public interface NullObject {

    /**
     * Class can have a null status, instead of having an actuall null reference;
     * Implementation of null object pattern
     * @return
     */
    boolean isNull();
}
