package com.miki.rms.domain.model.user;

import com.miki.rms.domain.model.user.settings.UserCategory;
import org.junit.Test;

/**
 * User can CRUD a category with subcategories
 * Created by miki on 26.12.2015.
 */
public class RootUserCategoriesTest extends AbstractUserTest {

    @Test
    public void rootCanAddCategory() {
        RootUser rootUser = this.generateRootUser().findRootUser(null);
        rootUser.getUserCategories().addCategory(
                new UserCategory("category")
        );
    }

}
