package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.enums.SocialNetwork;
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


    public Map<SocialNetwork, SocialNetworkConnection> getSocialNetworkConnections() {
        return socialNetworkConnections;
    }

    public UserCategories getUserCategories() {
        return userCategories;
    }

    public RootUser(UserIdentity userIdentity) {
        super(userIdentity);
    }

    @Override
    public RootUser findUserRoot(final UserRepository userRepository) {
        return this;
    }
    
}
