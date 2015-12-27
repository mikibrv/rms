package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * How we create a user
 * Created by miki on 26.12.2015.
 */
public class UserCreationTest {

    private static final String MOCK_EMAIL = "test@test.com";

    @Test
    public void createNewRootUser() {
        User rootUser = new UserBuilder()
                .setEmail(MOCK_EMAIL).build();
        assertNotNull(rootUser);
        assertTrue(rootUser.isRoot());
    }

    @Test
    public void createNewContactUser() {
        User rootUser = new UserBuilder()
                .setEmail(MOCK_EMAIL)
                .setContactOf(new UserIdentity(new UserEmail("root@test.com")))
                .build();
        assertNotNull(rootUser);
        assertFalse(rootUser.isRoot());
    }

    @Test(expected = InvalidUserTypeException.class)
    public void contactCannotBeAssignedToHimself() {
        new UserBuilder()
                .setEmail(MOCK_EMAIL)
                .setContactOf(new UserIdentity(new UserEmail(MOCK_EMAIL)))
                .build();
    }


}
