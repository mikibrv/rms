package com.miki.rms.domain.model.user.contact;

import com.miki.rms.domain.model.user.User;
import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.data.UserProfile;
import com.miki.rms.domain.model.user.exceptions.InvalidUserTypeException;
import com.miki.rms.domain.model.user.repository.UserRepository;
import com.miki.rms.domain.model.user.root.RootUser;
import com.miki.rms.domain.model.user.settings.UserCategory;
import com.miki.rms.domain.shared.Entity;

/** Created by miki on 26.12.2015. */
public class ContactUser extends User implements Entity<User> {

    /** Category this user belongs to; */
    private UserCategory category;

    protected ContactUser(final UserIdentity userIdentity) {
        super(userIdentity);
        if (userIdentity.isRoot()) {
            throw new InvalidUserTypeException();
        }
    }

    /** @param userIdentity
     * @param userProfile
     * @param category */
    protected ContactUser(final UserIdentity userIdentity, final UserProfile userProfile, final UserCategory category) {
        super(userIdentity, userProfile);
        this.category = category;
    }

    protected ContactUser(final UserIdentity userIdentity, final UserCategory category) {
        super(userIdentity);
        this.category = category;
    }

    public UserCategory getCategory() {
        return category;
    }

    public ContactUser addIntoCategory(final UserCategory category) {
        this.category = category;
        return this;
    }

    @Override
    public RootUser findRootUser(final UserRepository userRepository) {
        return (RootUser) userRepository.findOne(this.getUserIdentity().getContactOf());
    }
}
