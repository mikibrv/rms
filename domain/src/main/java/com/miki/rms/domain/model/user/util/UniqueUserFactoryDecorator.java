package com.miki.rms.domain.model.user.util;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.exceptions.DuplicateUserException;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.shared.Decorable;

/** Created by mikibrv on 01/02/16. */
public class UniqueUserFactoryDecorator implements UserFactory, Decorable<UserFactory> {

    private UserFactory actualFactory;

    /** Builds a user based on a factory;
     *
     * @param userRepository
     * @return */
    @Override
    public User build(final UserRepository userRepository) {
        User user = actualFactory.build(userRepository);
        if (userRepository.findOne(user.getUserIdentity()) != null) {
            throw new DuplicateUserException();
        }
        return user;
    }

    /** Returns the builder based on user
     *
     * @param user
     * @return */
    @Override
    public UserBuilder toBuilder(final User user) {
        return actualFactory.toBuilder(user);
    }

    /** Decorate with a specific decorator;
     *
     * @param toBeDecorated */
    @Override
    public UserFactory decorate(final UserFactory toBeDecorated) {
        this.actualFactory = toBeDecorated;
        return this;
    }
}
