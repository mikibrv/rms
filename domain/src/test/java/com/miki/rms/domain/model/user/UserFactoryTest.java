package com.miki.rms.domain.model.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.miki.rms.domain.model.constants.StringConstants;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.util.UserIdentityGenerator;

/** Created by mikibrv on 27/01/16. */
public class UserFactoryTest {
    @Test
    public void testDeserializationRoot() {
        String email = "root@root.com";
        UserIdentity userIdentity = UserIdentityGenerator.fromSerializedString(email);
        assertNotNull(userIdentity);
        assertEquals(userIdentity.getPrimaryEmail().getEmail(), email);
    }

    @Test
    public void testDeserializationContact() {
        String contact = "contact@root.com";
        String root = "root@root.com";

        UserIdentity userIdentity = UserIdentityGenerator
                .fromSerializedString(contact + StringConstants.ENTITY_SEPARATOR + root);
        assertNotNull(userIdentity);
        assertEquals(userIdentity.getPrimaryEmail().getEmail(), contact);
        assertEquals(userIdentity.getContactOf().getPrimaryEmail().getEmail(), root);
    }
}
