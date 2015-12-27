package com.miki.rms.domain.model.user.socialnetwork;

import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.enums.SocialNetworkToken;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores data related to this users connection to a specific social network;
 * Created by miki on 08.12.2015.
 */
public class SocialNetworkConnection {

    /**
     *
     */
    private SocialNetwork socialNetwork;

    private SocialNetworkUserData socialNetworkUserData;

    /**
     * Was the connection validated?
     * As in an initial connection / login / auth was ok
     */
    private boolean valid = Boolean.FALSE;

    /**
     * Cookies related to the connection with the social network;
     */
    private final Map<String, String> cookies = new HashMap<>();

    private final Map<SocialNetworkToken, String> tokens = new HashMap<>();


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
}
