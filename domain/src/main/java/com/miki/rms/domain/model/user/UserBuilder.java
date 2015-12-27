package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;

/**
 * Created by miki on 25.12.2015.
 */
public class UserBuilder {


    private UserEmail email;
    private UserIdentity contactOf;


    public UserBuilder setEmail(String email) {
        this.email = new UserEmail(email);
        return this;
    }

    public UserBuilder setContactOf(UserIdentity contactOf) {
        this.contactOf = contactOf;
        return this;
    }

    public User build() {
        UserIdentity identity = buildIdentity();
        if (identity.isRoot()) {
            return new RootUser(identity);
        }
        if (identity.getPrimaryEmail().sameValueAs(this.contactOf.getPrimaryEmail())) {
            throw new InvalidUserTypeException();
        }
        return new ContactUser(identity);
    }

    protected UserIdentity buildIdentity() {
        if (contactOf == null) {
            return new UserIdentity(email);
        }
        return new UserIdentity(email, contactOf);
    }


}
