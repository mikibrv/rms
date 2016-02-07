package com.miki.rms.domain.model.user.root;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.model.user.settings.UserCategories;

/** Created by mikibrv on 26/01/16. */
public class RootUserFactory implements UserFactory {

    private final UserBuilder userBuilder;

    public RootUserFactory(final UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Override
    public User build(final UserRepository userRepository) {
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
    public UserBuilder toBuilder(final User user) {
        RootUser rootUser = (RootUser) user;
        return userBuilder.setUserIdentity(rootUser.getUserIdentity())
                .setSocialNetworkConnections(rootUser.getSocialNetworkConnections())
                .setUserCategories(rootUser.getUserCategories())
                .setUserProfile(rootUser.getUserProfile());
    }

    private void ensureHasCategories() {
        if (this.userBuilder.getUserCategories() == null) {
            this.userBuilder.setUserCategories(new UserCategories());
        }
    }

}
