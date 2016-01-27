package com.miki.rms.domain.model.user.root;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.settings.UserCategories;

/** Created by mikibrv on 26/01/16. */
public class RootUserFactory implements UserFactory {

    private final UserBuilder userBuilder;
    private final RootUser userToBuilder;

    public RootUserFactory(final UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
        this.userToBuilder = null;
    }

    public RootUserFactory(final RootUser userToBuilder) {
        this.userBuilder = new UserBuilder();
        this.userToBuilder = userToBuilder;
    }

    @Override
    public User build() {
        final UserIdentity userIdentity = this.userBuilder.getUserIdentity();
        if (userIdentity.isRoot()) {
            this.ensureHasCategories();
            RootUser user = new RootUser(userIdentity, this.userBuilder.getUserProfile(),
                    this.userBuilder.getUserCategories());
            this.userBuilder.getSocialNetworkConnections().forEach(user::addSocialNetworkConnection);
            return user;
        }
        throw new InvalidUserTypeException();
    }

    /** returns the builder based on the userToBuilder;
     *
     * @return */
    @Override
    public UserBuilder toBuilder() {
        return userBuilder.setUserIdentity(this.userToBuilder.getUserIdentity())
                .setSocialNetworkConnections(this.userToBuilder.getSocialNetworkConnections())
                .setUserCategories(this.userToBuilder.getUserCategories())
                .setUserProfile(this.userToBuilder.getUserProfile());
    }

    private void ensureHasCategories() {
        if (this.userBuilder.getUserCategories() == null) {
            this.userBuilder.setUserCategories(new UserCategories());
        }
    }

}
