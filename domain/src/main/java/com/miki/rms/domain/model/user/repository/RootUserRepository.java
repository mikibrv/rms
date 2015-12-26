package com.miki.rms.domain.model.user.repository;

import com.miki.rms.domain.model.user.ContactUser;
import com.miki.rms.domain.model.user.RootUser;

import java.util.List;

/**
 * Created by miki on 26.12.2015.
 */
public interface RootUserRepository extends UserRepository {

    List<ContactUser> findContacts(final RootUser rootUser, final int skip, final int limit);

}
