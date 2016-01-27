package com.miki.rms.domain.model.user.enums;

/** Created by miki on 26.12.2015. */
public enum SocialNetworkToken {

    TOKEN("token");

    private String name;

    SocialNetworkToken(final String name) {
        this.name = name;
    }

    /**
     * returns the name of the social network
     * @return
     */
    public String toString() {
        return this.name;
    }

}
