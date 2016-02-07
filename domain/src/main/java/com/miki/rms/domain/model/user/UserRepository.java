package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.shared.repository.DomainRepository;

/** Created by miki on 08.12.2015. */
public interface UserRepository extends DomainRepository<UserIdentity, User> {

}
