package com.miki.rms.domain.model.user;

/** Created by mikibrv on 26/01/16. */
public interface UserFactory {

    /** Builds a user based on a factory;
     *
     * @return */
    User build(final UserRepository userRepository);

    /** Returns the builder based on user
     * 
     * @param user
     * @return */
    UserBuilder toBuilder(final User user);

}

