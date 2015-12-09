package com.miki.rms.domain.valueobjects;


import com.miki.rms.domain.entities.UserEntity;
import com.miki.rms.domain.valueobjects.enums.SocialNetwork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miki on 08.12.2015.
 */
public class User {

    private UserEntity userContact = null;



    private UserProfile userProfile;

    private List<UserCategory> userCategoryList;

    private Map<SocialNetwork, SocialNetworkConnection> connectionsMap =
            new HashMap<SocialNetwork, SocialNetworkConnection>();


}
