package com.miki.rms.domain.model.user;


import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.data.UserProfile;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.shared.Entity;

/**
 * Created by miki on 08.12.2015.
 */
public abstract class User implements Entity<User> {


    /**
     * Defines the identity of this entity;
     */
    private final UserIdentity userIdentity;


    /**
     * Data from this user brought from social networks;
     */
    private final UserProfile userProfile = new UserProfile();

    protected User(final UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public final UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public final boolean sameIdentityAs(final User other) {
        return this.userIdentity.equals(other.getUserIdentity());
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public final boolean isRoot() {
        return this.userIdentity.isRoot();
    }

    /**
     * Retrieve root user.Overriden in rootuser;
     *
     * @param userRepository
     * @return
     */
    public abstract RootUser findRootUser(final UserRepository userRepository);

}
