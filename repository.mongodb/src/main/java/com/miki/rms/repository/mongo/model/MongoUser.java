package com.miki.rms.repository.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.miki.rms.domain.model.user.UserBuilder;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.util.UserIdentityGenerator;

/** Created by mikibrv on 26/01/16. */
@Document
public class MongoUser extends UserBuilder {

    @Id
    private String id;

    public MongoUser() {
    }

    public MongoUser(final UserBuilder other) {
        super(other);
        this.id = UserIdentityGenerator.serializeUserIdentity(other.getUserIdentity());
    }

    public String getId() {
        return id;
    }

    /** @param id
     * @return */
    public MongoUser setId(final String id) {
        this.id = id;
        this.userIdentity = UserIdentityGenerator.fromSerializedString(id);
        return this;
    }

    @Override
    public UserBuilder setUserIdentity(final UserIdentity userIdentity) {
        super.setUserIdentity(userIdentity);
        this.id = UserIdentityGenerator.serializeUserIdentity(userIdentity);
        return this;
    }
}
