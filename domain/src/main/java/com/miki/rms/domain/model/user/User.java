package com.miki.rms.domain.model.user;

import java.util.Objects;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.data.UserProfile;
import com.miki.rms.domain.model.user.rootuser.RootUser;
import com.miki.rms.domain.shared.Entity;

/** Created by miki on 08.12.2015. */
public abstract class User implements Entity<User> {

    /** Defines the identity of this entity; */
    private final UserIdentity userIdentity;

    /** Data from this user brought from social networks; */
    private UserProfile userProfile;

    protected User(final UserIdentity userIdentity, final UserProfile userProfile) {
        this.userIdentity = userIdentity;
        this.userProfile = userProfile;
    }

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

    /** Retrieve root user.Overriden in rootuser;
     *
     * @param userRepository
     * @return */
    public abstract RootUser findRootUser(final UserRepository userRepository);

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(userIdentity, user.userIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdentity);
    }
}
