package com.miki.rms.domain.model.user.socialnetwork;

import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.shared.ValueObject;

/**
 * Created by miki on 26.12.2015.
 */
public class SocialNetworkUserData implements ValueObject<SocialNetworkUserData> {

    private SocialNetwork socialNetwork;

    /**
     * User id on the social Network. If not defined, we replace it with email
     */
    private String socialNetworkUserId;

    /**
     * User email on social network
     */
    private UserEmail socialNetworkUserEmail;


    public SocialNetworkUserData(final SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialNetworkUserData that = (SocialNetworkUserData) o;

        return socialNetwork == that.socialNetwork;

    }

    protected SocialNetworkUserData setSocialNetworkUserId(String socialNetworkUserId) {
        this.socialNetworkUserId = socialNetworkUserId;
        return this;
    }

    protected SocialNetworkUserData setSocialNetworkUserEmail(UserEmail socialNetworkUserEmail) {
        this.socialNetworkUserEmail = socialNetworkUserEmail;
        return this;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public String getSocialNetworkUserId() {
        return socialNetworkUserId;
    }

    public UserEmail getSocialNetworkUserEmail() {
        return socialNetworkUserEmail;
    }

    @Override
    public int hashCode() {
        return socialNetwork.hashCode();
    }

    @Override
    public boolean sameValueAs(SocialNetworkUserData other) {
        return this.equals(other);
    }
}
