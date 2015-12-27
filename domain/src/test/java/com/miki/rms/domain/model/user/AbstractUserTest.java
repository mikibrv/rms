package com.miki.rms.domain.model.user;

import com.miki.rms.domain.AbstractDomainTest;
import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miki on 26.12.2015.
 */
public abstract class AbstractUserTest extends AbstractDomainTest {

    protected static final String ROOT_USER_EMAIL = "root@test.com";


    protected final User generateRootUser() {
        return new UserBuilder().setEmail(ROOT_USER_EMAIL).build();
    }

    protected final List<User> generateListOfContacts() {
        return new ArrayList<User>() {{
            add(new UserBuilder().setEmail("contact1@test.com")
                    .setContactOf(new UserIdentity(new UserEmail(ROOT_USER_EMAIL))).build());
            add(new UserBuilder().setEmail("contact2@test.com")
                    .setContactOf(new UserIdentity(new UserEmail(ROOT_USER_EMAIL))).build());
            add(new UserBuilder().setEmail("contact3@test.com")
                    .setContactOf(new UserIdentity(new UserEmail(ROOT_USER_EMAIL))).build());
            add(new UserBuilder().setEmail("contact4@test.com")
                    .setContactOf(new UserIdentity(new UserEmail(ROOT_USER_EMAIL))).build());

        }};
    }

}
