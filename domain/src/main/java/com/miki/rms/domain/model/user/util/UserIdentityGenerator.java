package com.miki.rms.domain.model.user.util;

import com.miki.rms.domain.model.constants.StringConstants;
import com.miki.rms.domain.model.user.data.UserEmail;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;

/** Created by mikibrv on 01/02/16. */
public class UserIdentityGenerator {

    public static UserIdentity fromSerializedString(final String id) {
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

    public static String serializeUserIdentity(final UserIdentity userIdentity) {
        return userIdentity.toString();
    }
}
