package com.miki.rms.domain.model.user.data;

import com.miki.rms.domain.model.constants.StringConstants;
import com.miki.rms.domain.shared.DomainException;
import com.miki.rms.domain.shared.ValueObject;
import com.miki.rms.domain.shared.validators.ValidatorProvider;

/** UserIdentity defined by email and
 * <p/>
 * Created by miki on 13.12.2015. */
public class UserIdentity implements ValueObject<UserIdentity> {

    /** Primary email. Can have alternative emails. */
    private UserEmail primaryEmail;
    /** If this user is acting as a contact for some other user; */
    private UserIdentity contactOf;

    public UserIdentity(final UserEmail primaryEmail) {
        ValidatorProvider.getInstance().nullValidator().raiseExceptionIfInvalid(primaryEmail,
                DomainException.GenericDomainException.class, "Primary email required, null provided");
        this.primaryEmail = primaryEmail;
    }

    public UserIdentity(final UserEmail primaryEmail, UserIdentity contactOf) {
        this(primaryEmail);
        this.contactOf = contactOf;
    }

    public UserIdentity() {
    }

    public UserEmail getPrimaryEmail() {
        return primaryEmail;
    }

    public UserIdentity getContactOf() {
        return contactOf;
    }

    @Override
    public String toString() {
        return this.contactOf == null ? this.primaryEmail.getEmail()
                : this.primaryEmail.getEmail() + StringConstants.ENTITY_SEPARATOR + this.contactOf.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserIdentity that = (UserIdentity) o;

        if (primaryEmail != null ? !primaryEmail.equals(that.primaryEmail) : that.primaryEmail != null)
            return false;
        return !(contactOf != null ? !contactOf.equals(that.contactOf) : that.contactOf != null);

    }

    @Override
    public int hashCode() {
        int result = primaryEmail != null ? primaryEmail.hashCode() : 0;
        result = 31 * result + (contactOf != null ? contactOf.hashCode() : 0);
        return result;
    }

    public boolean sameValueAs(final UserIdentity other) {
        return this.equals(other);
    }

    /** User is root if he is nobodys contact;
     *
     * @return */
    public final boolean isRoot() {
        return this.contactOf == null;
    }
}
