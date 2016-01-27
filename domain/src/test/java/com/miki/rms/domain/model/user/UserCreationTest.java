package com.miki.rms.domain.model.user;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;

/** How we create a user Created by miki on 26.12.2015. */
public class UserCreationTest {

    private static final UserEmail MOCK_EMAIL = new UserEmail("root@test.com");
    private static final UserBuilder CONTACT_USER = new UserBuilder()
            .setUserIdentity(new UserIdentity(new UserEmail("contact@test.com"), new UserIdentity(MOCK_EMAIL)));

    @Test
    public void createNewRootUser() {
        User rootUser = UserFactory.getFactory(new UserBuilder()
                .setUserIdentity(new UserIdentity(MOCK_EMAIL)))
                .build();
        assertNotNull(rootUser);
        assertTrue(rootUser.isRoot());
    }

    @Test
    public void createNewContactUser() {
        User rootUser = UserFactory.getFactory(CONTACT_USER)
                .build();
        assertNotNull(rootUser);
        assertFalse(rootUser.isRoot());
    }

    @Test(expected = InvalidUserTypeException.class)
    public void contactCannotBeAssignedToHimself() {
        UserFactory.getFactory(new UserBuilder().setUserIdentity(new UserIdentity(MOCK_EMAIL,
                new UserIdentity(MOCK_EMAIL))))
                .build();
    }

}
