package com.miki.rms.domain.model.user.settings;

import com.miki.rms.domain.shared.ValueObject;

import java.util.HashSet;
import java.util.Set;

/**
 * A user can define a list of categories;
 * Created by miki on 13.12.2015.
 */
public class UserCategories implements ValueObject<UserCategories> {

    /**
     * Represents a list of categories defined by an user;
     */
    private Set<UserCategory> categories = new HashSet<UserCategory>();


    public boolean sameValueAs(final UserCategories other) {
        return this.equals(other);
    }

    public void addCategory(final UserCategory userCategory) {
        this.categories.add(userCategory);
    }

    public void removeCategory(final UserCategory userCategory) {
        this.categories.remove(userCategory);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCategories that = (UserCategories) o;

        return categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return categories.hashCode();
    }
}
