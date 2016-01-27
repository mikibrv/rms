package com.miki.rms.domain.model.user.socialnetwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.enums.SocialNetworkToken;

/** Stores data related to this users connection to a specific social network; Created by miki on 08.12.2015. */
public class SocialNetworkConnection {

    /** Cookies related to the connection with the social network; */
    private final Map<String, String> cookies = new HashMap<>();
    private final Map<SocialNetworkToken, String> tokens = new HashMap<>();
    /**
     *
     */
    private SocialNetwork socialNetwork;
    private SocialNetworkUserData socialNetworkUserData;
    /** Was the connection validated? As in an initial connection / login / auth was ok */
    private boolean valid = Boolean.FALSE;

    public SocialNetworkConnection(final SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public SocialNetwork getSocialNetwork() {
        return socialNetwork;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void addCookie(final String key, final String value) {
        this.cookies.put(key, value);
    }

    public Map<SocialNetworkToken, String> getTokens() {
        return tokens;
    }

    public void addToken(final SocialNetworkToken token, final String value) {
        this.tokens.put(token, value);
    }

    public SocialNetworkUserData getSocialNetworkUserData() {
        return socialNetworkUserData;
    }

    public boolean isValidated() {
        return this.valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SocialNetworkConnection that = (SocialNetworkConnection) o;
        if (this.getSocialNetworkUserData().getSocialNetworkUserEmail() == null
                || that.getSocialNetworkUserData().getSocialNetworkUserEmail() == null) {
            return false;
        }
        return Objects.equals(socialNetwork, that.socialNetwork) &&
                Objects.equals(socialNetworkUserData.getSocialNetworkUserEmail(),
                        that.socialNetworkUserData.getSocialNetworkUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialNetwork, socialNetworkUserData);
    }
}
