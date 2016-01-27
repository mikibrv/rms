package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.constants.StringConstants;
import com.miki.rms.domain.model.user.contact.ContactUser;
import com.miki.rms.domain.model.user.contact.ContactUserFactory;
import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.root.RootUser;
import com.miki.rms.domain.model.user.root.RootUserFactory;

/** Created by mikibrv on 26/01/16. */
public interface UserFactory {

    static UserFactory getFactory(final UserBuilder userBuilder) {
        if (userBuilder.getUserIdentity().isRoot()) {
            return new RootUserFactory(userBuilder);
        } else {
            return new ContactUserFactory(userBuilder);
        }
    }

    static UserFactory getFactory(final User user) {
        if (user.isRoot()) {
            return new RootUserFactory((RootUser) user);
        } else {
            return new ContactUserFactory((ContactUser) user);
        }
    }

    static UserIdentity fromSerializedString(final String id) {
        if (id == null) {
            throw new InvalidUserTypeException();
        }
        if (id.contains(StringConstants.ENTITY_SEPARATOR)) {
            String[] splittedId = id.split(StringConstants.ENTITY_SEPARATOR);
            if (splittedId.length == 2) {
                return new UserIdentity(new UserEmail(splittedId[0]),
                        new UserIdentity(new UserEmail(splittedId[1])));
            } else {
                throw new InvalidUserTypeException();
            }
        }
        return new UserIdentity(new UserEmail(id));
    }

    static String serializeUserIdentity(final UserIdentity userIdentity) {
        return userIdentity.toString();
    }

    /** Builds a user based on a factory;
     *
     * @return */
    User build();

    /** returns the builder based on the user;
     * 
     * @return */
    UserBuilder toBuilder();

}
