package com.miki.rms.domain.specification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.miki.rms.domain.AbstractDomainTest;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.events.UserConnectedToNetworkEvent;
import com.miki.rms.domain.model.user.rootuser.RootUser;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnectionBuilder;
import com.miki.rms.domain.model.user.util.UserFactoryStrategy;
import com.miki.rms.domain.model.user.util.UserIdentityGenerator;

/** This test handles specification of adding a new social network connection, validates the processing of events after
 * the network was added; Created by mikibrv on 07/02/16. */
public class UserAddSocialNetworkConnection extends AbstractDomainTest {

    private RootUser rootUser;

    @Before
    public void init() {
        rootUser = (RootUser) UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                new UserBuilder().setUserIdentity(UserIdentityGenerator.fromSerializedString("miki@miki.com")))
                .build(null);
    }

    @Test
    public void userAddSocialNetworkConnectionGeneratesEvent() {
        assertNotNull(rootUser);
        UserConnectedToNetworkEvent event = rootUser.addSocialNetworkConnection(new SocialNetworkConnectionBuilder()
                .setSocialNetwork(SocialNetwork.FACEBOOK).createSocialNetworkConnection());
        assertFalse(event.isNull());
    }

}
