package com.miki.rms.domain.model.user.util;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.contactuser.ContactUserFactory;
import com.miki.rms.domain.model.user.rootuser.RootUserFactory;
import com.miki.rms.domain.shared.Decorable;

/** Enables adding decorators to the simple user factory; Created by mikibrv on 07/02/16. */
public enum UserFactoryStrategy {

    UNIQUE_USER_FACTORY(UniqueUserFactoryDecorator.class), SIMPLE_USER_FACTORY(null);

    /** Decorator for the user factory; */
    private final Class<? extends Decorable> decorator;

    UserFactoryStrategy(final Class<? extends Decorable> decoratorClass) {
        this.decorator = decoratorClass;
    }

    /** Returns a userBuilder from an User
     *
     * @param user to be transformed
     * @return */
    public UserBuilder getBuilder(final User user) {
        if (user.isRoot()) {
            return new RootUserFactory(new UserBuilder()).toBuilder(user);
        } else {
            return new ContactUserFactory(new UserBuilder()).toBuilder(user);
        }
    }

    /** returns a factory based on a user builder;
     * 
     * @param userBuilder
     * @return */
    public UserFactory getFactory(final UserBuilder userBuilder) {
        if (userBuilder.getUserIdentity().isRoot()) {
            return this.decorate(new RootUserFactory(userBuilder));
        } else {
            return this.decorate(new ContactUserFactory(userBuilder));
        }
    }

    /** decorates if necessary the factory;
     * 
     * @param toBeDecorated
     * @return */
    private UserFactory decorate(final UserFactory toBeDecorated) {
        if (this.decorator != null) {
            try {
                return (UserFactory) this.decorator.newInstance().decorate(toBeDecorated);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return toBeDecorated;
    }

}
