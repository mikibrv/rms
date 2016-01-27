package com.miki.rms.domain.model.user.repository;

import java.util.List;

import com.miki.rms.domain.model.user.contact.ContactUser;
import com.miki.rms.domain.model.user.root.RootUser;

/** Created by miki on 26.12.2015. */
public interface RootUserRepository extends UserRepository {

    List<ContactUser> findContacts(final RootUser rootUser, final int skip, final int limit);

}
