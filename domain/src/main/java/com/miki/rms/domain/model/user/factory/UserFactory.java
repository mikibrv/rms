package com.miki.rms.domain.model.user.factory;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserEmail;
import com.miki.rms.domain.model.user.UserIdentity;

/**
 * Created by miki on 25.12.2015.
 */
public class UserFactory {

    User buildUser() {
        return new User(new UserIdentity(new UserEmail("test@test.com")));
    }
}
