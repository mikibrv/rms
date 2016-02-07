package com.miki.rms.domain.model.user;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.DuplicateUserException;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.util.UserFactoryStrategy;

/** How we create a user Created by miki on 26.12.2015. */
public class UserCreationTest extends AbstractUserTest {

    private static final UserEmail MOCK_EMAIL = new UserEmail("root@test.com");
    private static final UserBuilder CONTACT_USER = new UserBuilder()
            .setUserIdentity(new UserIdentity(new UserEmail("contact@test.com"), new UserIdentity(MOCK_EMAIL)));

    @Test
    public void createNewRootUser() {
        User rootUser = UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(new UserBuilder()
                .setUserIdentity(new UserIdentity(MOCK_EMAIL)))
                .build(this.userRepository);
        assertNotNull(rootUser);
        assertTrue(rootUser.isRoot());
    }

    @Test
    public void createNewContactUser() {
        User rootUser = UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(CONTACT_USER)
                .build(this.userRepository);
        assertNotNull(rootUser);
        assertFalse(rootUser.isRoot());
    }

    @Test(expected = InvalidUserTypeException.class)
    public void contactCannotBeAssignedToHimself() {
        UserFactoryStrategy.SIMPLE_USER_FACTORY
                .getFactory(new UserBuilder().setUserIdentity(new UserIdentity(MOCK_EMAIL,
                        new UserIdentity(MOCK_EMAIL))))
                .build(this.userRepository);
    }

    @Test(expected = DuplicateUserException.class)
    public void uniqueDecoratorWillNotAllowDuplicatedUsers() {
        final UserRepository userRepository = Mockito.mock(UserRepository.class);
        final String email = "duplicated.user@test.com";
        User user = UserFactoryStrategy.SIMPLE_USER_FACTORY
                .getFactory(new UserBuilder().setUserIdentity(new UserIdentity(
                        new UserEmail(email))))
                .build(userRepository);
        when(userRepository.findOne(new UserIdentity(new UserEmail(email)))).thenReturn(
                user);

        UserFactoryStrategy.UNIQUE_USER_FACTORY.getFactory(new UserBuilder().setUserIdentity(new UserIdentity(
                new UserEmail(email)))).build(userRepository);
    }

}
