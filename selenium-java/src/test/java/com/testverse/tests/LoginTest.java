package com.testverse.tests;

import com.testverse.base.BaseTest;
import com.testverse.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validUserCanLogin() {
        InventoryPage inventory = loginPage.loginAs("standard_user", "secret_sauce");
        Assert.assertEquals(inventory.getTitle(), "Products");
    }

    @Test
    public void invalidPasswordShowsError() {
        loginPage.loginExpectingFailure("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("do not match"));
    }

    @Test
    public void lockedOutUserSeesError() {
        loginPage.loginExpectingFailure("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }

    @Test
    public void emptyUsernameShowsError() {
        loginPage.loginExpectingFailure("", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }
}