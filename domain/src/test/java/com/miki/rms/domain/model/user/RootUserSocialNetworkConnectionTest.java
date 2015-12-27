package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.enums.SocialNetwork;
import com.miki.rms.domain.model.user.enums.SocialNetworkToken;
import com.miki.rms.domain.model.user.events.UserConnectedToNetworkEvent;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnection;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by miki on 26.12.2015.
 */
public class RootUserSocialNetworkConnectionTest extends AbstractUserTest {

    static SocialNetworkConnection stubNetworkConnection = new SocialNetworkConnection(
            SocialNetwork.STUB);

    static SocialNetworkConnection mockedValidNetworkConnection;
    static SocialNetworkConnection mockedInValidNetworkConnection;


    @BeforeClass
    public static void setUp() {
        mockedValidNetworkConnection = spy(stubNetworkConnection);
        when(mockedValidNetworkConnection.isValidated()).thenReturn(Boolean.TRUE);

        mockedInValidNetworkConnection = spy(stubNetworkConnection);
        when(mockedInValidNetworkConnection.isValidated()).thenReturn(Boolean.FALSE);
    }

    @Test
    public void rootUserCanHaveValidSocialNetworkConnection() {
        RootUser user = this.generateRootUser().findRootUser(null);
        assertNotNull(user.addSocialNetworkConnection(mockedValidNetworkConnection));
        assertTrue(user.getSocialNetworkConnections().containsKey(SocialNetwork.STUB));

        //we should be able to override this;
        SocialNetworkConnection stubConnection = mockedValidNetworkConnection;
        stubConnection.addToken(SocialNetworkToken.TOKEN, "testvalue");
        user.addSocialNetworkConnection(stubConnection);
        assertTrue(user.getSocialNetworkConnections().get(stubConnection.getSocialNetwork()).getTokens().equals(
                stubConnection.getTokens()));
    }

    @Test
    public void rootUserNotAllowedToAddInvalidConnection() {
        RootUser user = this.generateRootUser().findRootUser(null);
        UserConnectedToNetworkEvent event = user.addSocialNetworkConnection(mockedInValidNetworkConnection);
        assertTrue(event.isNull());
        assertFalse(user.getSocialNetworkConnections().containsKey(mockedInValidNetworkConnection.getSocialNetwork()));
    }

    @Test
    public void rootUserAddSocialNetworkGeneratesEvent() {
        RootUser user = this.generateRootUser().findRootUser(null);
        UserConnectedToNetworkEvent event = user.addSocialNetworkConnection(mockedValidNetworkConnection);
        assertEquals(mockedValidNetworkConnection, event.getSocialNetworkConnection());
        assertEquals(user.getUserIdentity(), event.getUserIdentity());
    }

    @Test
    public void rootUserCannotRemoveSocialNetworkConnection() {
        RootUser user = this.generateRootUser().findRootUser(null);
        user.addSocialNetworkConnection(mockedValidNetworkConnection);
        user.getSocialNetworkConnections().clear();
        assertTrue(user.getSocialNetworkConnections().size() > 0);
    }


}
