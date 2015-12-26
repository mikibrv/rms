package com.miki.rms.domain.model.user.data;

import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkUserData;
import com.miki.rms.domain.shared.ValueObject;

import java.util.*;

/**
 * Data about our user.
 * Also data brought from his social networks;
 * First social Network is the one with data in this object.
 * Users can be merged
 * Created by miki on 26.12.2015.
 */
public class UserProfile implements ValueObject<UserProfile> {

    private String name;

    private String photoUrl;

    private String bio;

    private List<UserOccupation> userOccupationList = new LinkedList<>();

    private Map<SocialNetwork, SocialNetworkUserData> socialNetworkUserData = new HashMap<>();

    /**
     * Like skills and whatever else;
     */
    private Set<String> tags = new HashSet<>();


    @Override
    public boolean sameValueAs(UserProfile other) {
        return this.equals(other);
    }
}
