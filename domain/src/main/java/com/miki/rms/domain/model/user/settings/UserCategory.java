package com.miki.rms.domain.model.user.settings;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.miki.rms.domain.shared.ValueObject;

/** Created by miki on 13.12.2015. */
public class UserCategory implements ValueObject<UserCategory> {

    /** Represents the name of a category; */
    private final String category;

    /** Represents a list of subCategories for the current category; */
    private final List<UserCategories> subCategories = new ArrayList<UserCategories>();

    public UserCategory(final String category) {
        Validate.notNull(category);
        this.category = category;
    }

    public boolean sameValueAs(final UserCategory other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserCategory that = (UserCategory) o;

        return category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return category.hashCode();
    }
}
