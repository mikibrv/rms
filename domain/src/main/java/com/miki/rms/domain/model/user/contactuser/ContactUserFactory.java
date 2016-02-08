package com.miki.rms.domain.model.user.contactuser;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.UserRepository;

/** Created by mikibrv on 26/01/16. */
public class ContactUserFactory implements UserFactory {

    private final UserBuilder userBuilder;

    public ContactUserFactory(final UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public User build(final UserRepository userRepository) {
        UserIdentity userIdentity = this.userBuilder.getUserIdentity();
        if (!userIdentity.isRoot()
                && !isHimselfContact(userIdentity)) {
            return new ContactUser(userIdentity, this.userBuilder.getUserProfile(),
                    this.userBuilder.getUserCategory());
        }
        throw new InvalidUserTypeException();
    }

    /** returns the builder based on the user;
     *
     * @return */
    @Override
    public UserBuilder toBuilder(final User user) {
        ContactUser contactUser = (ContactUser) user;
        return userBuilder.setUserIdentity(contactUser.getUserIdentity())
                .setUserCategory(contactUser.getCategory())
                .setUserProfile(contactUser.getUserProfile());
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
