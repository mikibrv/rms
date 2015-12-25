package com.miki.rms.domain.shared;

/**
 * Describes the contract for an Entity as described in DDD.
 * Created by miki on 10.12.2015.
 */
public interface Entity<T> {


    /**
     * Entities compare by identity, not by attributes
     *
     * @param other The other entity
     * @return true f the identities are the same, regardles of other attributes
     */
    boolean sameIdentityAs(final T other);

}
