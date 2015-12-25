package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.exceptions.InvalidEmailException;
import com.miki.rms.domain.shared.ValueObject;
import com.miki.rms.domain.shared.validators.ValidatorProvider;

/**
 * Wrapper for an email;
 * Created by miki on 13.12.2015.
 */
public class UserEmail implements ValueObject<UserEmail> {

    private String email;
    private Boolean validated = Boolean.FALSE;

    public UserEmail(final String email) {
        ValidatorProvider.getInstance().emailValidator().raiseExceptionIfInvalid(email,
                InvalidEmailException.class, "Invalid email provided: {} ", email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isValidated() {
        return this.validated;
    }

    public void validateEmail() {
        this.validated = Boolean.TRUE;
    }

    public boolean hasEmailBeenValidate() {
        return this.validated;
    }

    public boolean sameValueAs(final UserEmail other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEmail userEmail = (UserEmail) o;
        return email.equals(userEmail.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
