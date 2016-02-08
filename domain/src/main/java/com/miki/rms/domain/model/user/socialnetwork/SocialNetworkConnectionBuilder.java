package com.miki.rms.domain.model.user.socialnetwork;

import com.miki.rms.domain.model.user.enums.SocialNetwork;

public class SocialNetworkConnectionBuilder {
    private SocialNetwork socialNetwork;
    private SocialNetworkUserData socialNetworkUserData;
    private boolean valid;

    public SocialNetworkConnectionBuilder setSocialNetwork(final SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
        return this;
    }

    public SocialNetworkConnectionBuilder setSocialNetworkUserData(final SocialNetworkUserData socialNetworkUserData) {
        this.socialNetworkUserData = socialNetworkUserData;
        return this;
    }

    public SocialNetworkConnectionBuilder setValid(final Boolean valid) {
        this.valid = valid;
        return this;
    }

    public SocialNetworkConnection createSocialNetworkConnection() {
        return new SocialNetworkConnection(socialNetwork, socialNetworkUserData, valid);
    }
}