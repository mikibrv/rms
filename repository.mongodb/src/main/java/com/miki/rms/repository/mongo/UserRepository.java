package com.miki.rms.repository.mongo;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.util.UserFactoryStrategy;
import com.miki.rms.domain.model.user.util.UserIdentityGenerator;
import com.miki.rms.repository.mongo.model.MongoUser;
import com.miki.rms.repository.mongo.model.MongoUserRepository;

/** Created by mikibrv on 26/01/16. */

public class UserRepository implements com.miki.rms.domain.model.user.UserRepository {

    final MongoUserRepository mongoUserRepository;

    /** @param mongoUserRepository */
    public UserRepository(final MongoUserRepository mongoUserRepository) {
        this.mongoUserRepository = mongoUserRepository;
    }

    @Override
    public User findOne(final UserIdentity userIdentity) {
        MongoUser mongoUser = mongoUserRepository.findOne(userIdentity.getPrimaryEmail().getEmail());
        if (mongoUser != null) {
            return UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(mongoUser).build(this);
        }
        return null;
    }

    @Override
    public User save(final User entity) {
        MongoUser mongoUser = mongoUserRepository.save(this.buildMongoUserFromEntity(entity));
        return UserFactoryStrategy.SIMPLE_USER_FACTORY.getFactory(mongoUser).build(this);
    }

    @Override
    public void delete(final User entity) {
        mongoUserRepository.delete(UserIdentityGenerator.serializeUserIdentity(entity.getUserIdentity()));
    }

    private MongoUser buildMongoUserFromEntity(final User entity) {
        return mongoUserRepository.save(
                new MongoUser(UserFactoryStrategy.SIMPLE_USER_FACTORY.getBuilder(entity)));
    }
}
