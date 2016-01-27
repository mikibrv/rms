package com.miki.rms.domain.model.user;

import java.util.HashSet;
import java.util.Set;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.data.UserProfile;
import com.miki.rms.domain.model.user.settings.UserCategories;
import com.miki.rms.domain.model.user.settings.UserCategory;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnection;

/** Created by mikibrv on 26/01/16. */
public class UserBuilder {

    protected UserIdentity userIdentity;
    protected UserProfile userProfile;
    protected UserCategory userCategory;
    protected Set<SocialNetworkConnection> socialNetworkConnections = new HashSet<>();
    protected UserCategories userCategories;

    public UserBuilder() {
    }

    public UserBuilder(final UserBuilder other) {
        this.userIdentity = other.userIdentity;
        this.userProfile = other.userProfile;
        this.userCategory = other.userCategory;
        this.socialNetworkConnections = other.socialNetworkConnections;
        this.userCategories = other.userCategories;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public UserBuilder setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
        return this;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public UserBuilder setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        return this;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public UserBuilder setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
        return this;
    }

    public Set<SocialNetworkConnection> getSocialNetworkConnections() {
        return socialNetworkConnections;
    }

    public UserBuilder setSocialNetworkConnections(Set<SocialNetworkConnection> socialNetworkConnections) {
        this.socialNetworkConnections = socialNetworkConnections;
        return this;
    }

    public UserCategories getUserCategories() {
        return userCategories;
    }

    public UserBuilder setUserCategories(UserCategories userCategories) {
        this.userCategories = userCategories;
        return this;
    }
}
