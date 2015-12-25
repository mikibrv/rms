package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.enums.SocialNetwork;

import java.util.HashMap;
import java.util.Map;

/**
 * This is an user that has connected to the app and has connections;
 * Has extra data about this users connection to social networks
 * Created by miki on 25.12.2015.
 */
public class RootUser extends User {


    /**
     * Social networks to which this user is connected;
     */
    private final Map<SocialNetwork, SocialNetworkConnection> socialNetworkConnections = new HashMap<>();


    public RootUser(UserIdentity userIdentity) {
        super(userIdentity);
    }
}
