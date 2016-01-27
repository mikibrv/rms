package com.miki.rms.domain.model.user.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkUserData;
import com.miki.rms.domain.shared.ValueObject;

/** Data about our user. Also data brought from his social networks; First social Network is the one with data in this
 * object. Users can be merged Created by miki on 26.12.2015. */
public class UserProfile implements ValueObject<UserProfile> {

    private String name;

    private String photoUrl;

    private String bio;

    private List<UserOccupation> userOccupationList = new LinkedList<>();

    private Map<SocialNetwork, SocialNetworkUserData> socialNetworkUserData = new HashMap<>();

    /** Like skills and whatever else; */

    private Set<String> tags = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(photoUrl, that.photoUrl) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(userOccupationList, that.userOccupationList) &&
                Objects.equals(socialNetworkUserData, that.socialNetworkUserData) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, photoUrl, bio, userOccupationList, socialNetworkUserData, tags);
    }

    @Override
    public boolean sameValueAs(UserProfile other) {
        return this.equals(other);
    }
}
