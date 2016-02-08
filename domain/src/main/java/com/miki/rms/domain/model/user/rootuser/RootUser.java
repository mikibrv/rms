package com.miki.rms.domain.model.user.rootuser;

import java.util.HashSet;
import java.util.Set;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserRepository;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.data.UserProfile;
import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.events.UserConnectedToNetworkEvent;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.settings.UserCategories;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnection;
import com.miki.rms.domain.shared.Entity;

/** This is an user that has connected to the app and has connections; Has extra data about this users connection to
 * social networks Created by miki on 25.12.2015. */
public class RootUser extends User implements Entity<User> {

    /** Social networks to which this user is connected; */
    private final Set<SocialNetworkConnection> socialNetworkConnections = new HashSet<>();

    /** Stores the root defined categories; */
    private UserCategories userCategories = new UserCategories();

    protected RootUser(final UserIdentity userIdentity) {
        super(userIdentity);
        if (!userIdentity.isRoot()) {
            throw new InvalidUserTypeException();
        }
    }

    protected RootUser(final UserIdentity userIdentity, final UserProfile userProfile,
            final UserCategories userCategories) {
        super(userIdentity, userProfile);
        this.userCategories = userCategories;
    }

    protected RootUser(final UserIdentity userIdentity, final UserCategories userCategories) {
        super(userIdentity);
        this.userCategories = userCategories;
    }

    public UserCategories getUserCategories() {
        return userCategories;
    }

    @Override
    public RootUser findRootUser(final UserRepository userRepository) {
        return this;
    }

    /** Adds a new social network connection for this user; Only validated connections can be added;
     *
     * @param socialNetworkConnection */
    public UserConnectedToNetworkEvent addSocialNetworkConnection(
            final SocialNetworkConnection socialNetworkConnection) {
        this.socialNetworkConnections.add(socialNetworkConnection);
        return new UserConnectedToNetworkEvent(this.getUserIdentity(), socialNetworkConnection);
    }

    public Set<SocialNetworkConnection> getSocialNetworkConnections() {
        return new HashSet<>(this.socialNetworkConnections);
    }

    public SocialNetworkConnection getConnection(final SocialNetwork socialNetwork) {
        return this.socialNetworkConnections.stream()
                .filter(p -> p.getSocialNetwork() == socialNetwork)
                .findFirst().orElse(null);
    }
}
