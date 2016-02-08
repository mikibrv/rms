package com.miki.rms.domain.model.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.miki.rms.domain.AbstractDomainTest;
import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.util.UserFactoryStrategy;

/** Created by miki on 26.12.2015. */
public abstract class AbstractUserTest extends AbstractDomainTest {

    protected static final String ROOT_USER_EMAIL = "root@test.com";
    final UserBuilder rootUser = new UserBuilder().setUserIdentity(
            new UserIdentity(new UserEmail(ROOT_USER_EMAIL)));
    final UserIdentity rootUserIdentity = generateRootUser().getUserIdentity();

    @Mock
    protected UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(AbstractUserTest.class);
        // will return what was sent
    }

    protected final User generateRootUser() {
        return UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(rootUser).build(userRepository);
    }

    protected final List<User> generateListOfContacts() {
        return new ArrayList<User>() {
            {
                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact1@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact2@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact3@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact4@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact5@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

                add(UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(
                        new UserBuilder()
                                .setUserIdentity(new UserIdentity(new UserEmail("contact6@test.com"),
                                        rootUserIdentity)))
                        .build(userRepository));

            }
        };
    }

}
