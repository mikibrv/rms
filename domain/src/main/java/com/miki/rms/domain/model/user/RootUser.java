package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.events.UserConnectedToNetworkEvent;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.model.user.settings.UserCategories;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnection;
import com.miki.rms.domain.shared.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an user that has connected to the app and has connections;
 * Has extra data about this users connection to social networks
 * Created by miki on 25.12.2015.
 */
public class RootUser extends User implements Entity<User> {

    /**
     * Social networks to which this user is connected;
     */
    private final Map<SocialNetwork, SocialNetworkConnection> socialNetworkConnections = new HashMap<>();

    /**
     * Stores the root defined categories;
     */
    private final UserCategories userCategories = new UserCategories();

    /**
     * @return a new hashmap, making changes go unnoticed;
     */
    public Map<SocialNetwork, SocialNetworkConnection> getSocialNetworkConnections() {
        return new HashMap<>(socialNetworkConnections);
    }

    public UserCategories getUserCategories() {
        return userCategories;
    }

    protected RootUser(final UserIdentity userIdentity) {
        super(userIdentity);
        if (!userIdentity.isRoot()) {
            throw new InvalidUserTypeException();
        }
    }

    @Override
    public RootUser findRootUser(final UserRepository userRepository) {
        return this;
    }

    /**
     * Adds a new social network connection for this user;
     * Only validated connections can be added;
     *
     * @param socialNetworkConnection
     */
    public UserConnectedToNetworkEvent addSocialNetworkConnection(SocialNetworkConnection socialNetworkConnection) {
        if (socialNetworkConnection.isValidated()) {
            this.socialNetworkConnections.put(socialNetworkConnection.getSocialNetwork(), socialNetworkConnection);
            return new UserConnectedToNetworkEvent(this.getUserIdentity(), socialNetworkConnection);
        }
        return UserConnectedToNetworkEvent.NONE;
    }
}
