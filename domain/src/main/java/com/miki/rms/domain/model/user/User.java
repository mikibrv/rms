package com.miki.rms.domain.model.user;


import com.miki.rms.domain.shared.Entity;

/**
 * Created by miki on 08.12.2015.
 */
public class User implements Entity<User> {


    /**
     * Defines the identity of this entity;
     */
    protected final UserIdentity userIdentity;

    public User(final UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public boolean sameIdentityAs(final User other) {
        return this.userIdentity.equals(other.getUserIdentity());
    }

    public boolean isRoot() {
        return this.userIdentity.isRoot();
    }

}
