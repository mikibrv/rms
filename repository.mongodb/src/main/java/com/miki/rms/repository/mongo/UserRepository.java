package com.miki.rms.repository.mongo;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.UserFactory;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.repository.mongo.model.MongoUser;
import com.miki.rms.repository.mongo.model.MongoUserRepository;

/** Created by mikibrv on 26/01/16. */

public class UserRepository implements com.miki.rms.domain.model.user.repository.UserRepository {

    MongoUserRepository mongoUserRepository;

    public UserRepository(final MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public User findOne(final UserIdentity userIdentity) {
        MongoUser mongoUser = mongoUserRepository.findOne(userIdentity.getPrimaryEmail().getEmail());
        if (mongoUser != null) {
            return UserFactory.getFactory(mongoUser).build();
        }
        return null;
    }

    @Override
    public User save(final User entity) {
        MongoUser mongoUser = mongoUserRepository.save(
                new MongoUser(UserFactory.getFactory(entity).toBuilder()));
        return UserFactory.getFactory(mongoUser).build();
    }

    @Override
    public void delete(final User entity) {
        mongoUserRepository.delete(UserFactory.serializeUserIdentity(entity.getUserIdentity()));
    }
}
