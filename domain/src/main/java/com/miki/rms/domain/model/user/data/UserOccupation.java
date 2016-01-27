package com.miki.rms.domain.model.user.data;

import java.util.Date;

import com.miki.rms.domain.shared.ValueObject;

/** Created by miki on 26.12.2015. */
public class UserOccupation implements ValueObject<UserOccupation> {

    private final String position;
    private final String company;
    private final Date since;
    private Date until;

    public UserOccupation(String position, String company, Date since) {
        this.position = position;
        this.company = company;
        this.since = since;
    }

    public UserOccupation(String position, String company, Date since, Date until) {
        this.position = position;
        this.company = company;
        this.since = since;
        this.until = until;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public Date getSince() {
        return since;
    }

    public Date getUntil() {
        return until;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserOccupation that = (UserOccupation) o;

        if (position != null ? !position.equals(that.position) : that.position != null)
            return false;
        if (company != null ? !company.equals(that.company) : that.company != null)
            return false;
        if (since != null ? !since.equals(that.since) : that.since != null)
            return false;
        return !(until != null ? !until.equals(that.until) : that.until != null);

    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (since != null ? since.hashCode() : 0);
        result = 31 * result + (until != null ? until.hashCode() : 0);
        return result;
    }

    @Override
    public boolean sameValueAs(UserOccupation other) {
        return this.equals(other);
    }
}
