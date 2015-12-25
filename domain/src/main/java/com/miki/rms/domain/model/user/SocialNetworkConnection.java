package com.miki.rms.domain.model.user;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miki on 08.12.2015.
 */
public class SocialNetworkConnection {

    /**
     * Cookies related to the connection with the social network;
     */
    private Map<String, String> cookies = new HashMap<String, String>();

    /**
     * User id on the social Network. If not defined, we replace it with email
     */
    private String socialNetworkId;

    /**
     * User email on social network
     */
    private UserEmail socialNetworkEmail;


}
