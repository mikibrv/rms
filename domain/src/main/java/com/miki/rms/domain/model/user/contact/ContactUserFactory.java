package com.miki.rms.domain.model.user.contact;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;

/** Created by mikibrv on 26/01/16. */
public class ContactUserFactory implements UserFactory {

    private final UserBuilder userBuilder;
    private final ContactUser user;

    public ContactUserFactory(final UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
        this.user = null;
    }

    public ContactUserFactory(final ContactUser user) {
        this.user = user;
        this.userBuilder = new UserBuilder();
    }

    @Override
    public User build() {
        UserIdentity userIdentity = this.userBuilder.getUserIdentity();
        if (!userIdentity.isRoot()
                && !isHimselfContact(userIdentity)) {
            return new ContactUser(userIdentity, this.userBuilder.getUserProfile(), this.userBuilder.getUserCategory());
        }
        throw new InvalidUserTypeException();
    }

    /** returns the builder based on the user;
     *
     * @return */
    @Override
    public UserBuilder toBuilder() {
        return userBuilder.setUserIdentity(user.getUserIdentity())
                .setUserCategory(user.getCategory())
                .setUserProfile(user.getUserProfile());
    }

    /** One cannot have himself as a root user;
     * 
     * @param userIdentity
     * @return */
    public boolean isHimselfContact(final UserIdentity userIdentity) {
        return userBuilder.getUserIdentity().getContactOf().getPrimaryEmail()
                .equals(userIdentity.getPrimaryEmail());
    }

}
