package com.miki.rms.domain.model.user.events;

import com.miki.rms.domain.model.user.data.UserIdentity;
import com.miki.rms.domain.model.user.socialnetwork.SocialNetworkConnection;
import com.miki.rms.domain.shared.DomainEvent;

/**
 * Generated when a new connection is added for a root user;
 * Created by miki on 26.12.2015.
 */
public class UserConnectedToNetworkEvent implements DomainEvent<UserConnectedToNetworkEvent> {

    private UserIdentity userIdentity;

    private SocialNetworkConnection socialNetworkConnection;

    /**
     * some null object pattern;
     */
    public static final UserConnectedToNetworkEvent NONE = new UserConnectedToNetworkEvent(null);

    public UserConnectedToNetworkEvent(final UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public UserConnectedToNetworkEvent(final UserIdentity userIdentity,
                                       SocialNetworkConnection socialNetworkConnection) {
        this.userIdentity = userIdentity;
        this.socialNetworkConnection = socialNetworkConnection;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public UserConnectedToNetworkEvent setUserIdentity(final UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
        return this;
    }

    public SocialNetworkConnection getSocialNetworkConnection() {
        return socialNetworkConnection;
    }

    public UserConnectedToNetworkEvent setSocialNetworkConnection(final
                                                                  SocialNetworkConnection socialNetworkConnection) {
        this.socialNetworkConnection = socialNetworkConnection;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserConnectedToNetworkEvent that = (UserConnectedToNetworkEvent) o;

        if (!userIdentity.equals(that.userIdentity)) return false;
        return socialNetworkConnection.equals(that.socialNetworkConnection);

    }

    @Override
    public int hashCode() {
        int result = userIdentity.hashCode();
        result = 31 * result + socialNetworkConnection.hashCode();
        return result;
    }

    @Override
    public boolean sameEventAs(UserConnectedToNetworkEvent other) {
        return this.equals(other);
    }

    @Override
    public boolean isNull() {
        return this.userIdentity == null || this.socialNetworkConnection == null;
    }
}
