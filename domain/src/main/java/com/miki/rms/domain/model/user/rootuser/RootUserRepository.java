package com.miki.rms.domain.model.user.rootuser;

import java.util.List;

import com.miki.rms.domain.model.user.UserRepository;
import com.miki.rms.domain.model.user.contactuser.ContactUser;

/** Created by miki on 26.12.2015. */
public interface RootUserRepository extends UserRepository {

    List<ContactUser> findContacts(final RootUser rootUser, final int skip, final int limit);

}
