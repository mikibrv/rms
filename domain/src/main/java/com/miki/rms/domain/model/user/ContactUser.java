package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.model.user.settings.UserCategory;
import com.miki.rms.domain.shared.Entity;

/**
 * Created by miki on 26.12.2015.
 */
public class ContactUser extends User implements Entity<User> {

    /**
     * Category this user belongs to;
     */
    private UserCategory category;


    public ContactUser(final UserIdentity userIdentity) {
        super(userIdentity);
    }

    public UserCategory getCategory() {
        return category;
    }

    public ContactUser setCategory(UserCategory category) {
        this.category = category;
        return this;
    }

    @Override
    public RootUser findUserRoot(final UserRepository userRepository) {
        return (RootUser) userRepository.findOne(this.getUserIdentity().getContactOf());
    }
}
