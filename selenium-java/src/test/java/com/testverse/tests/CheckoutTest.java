package com.testverse.tests;

import com.testverse.base.BaseTest;
import com.testverse.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void userCanCompleteCheckout() {
        CheckoutPage checkout = loginPage.loginAs("standard_user", "secret_sauce")
                .addToCart("sauce-labs-backpack")
                .openCart()
                .checkout()
                .fillInformation("Vishal", "Parvatikar", "560001")
                .finish();

        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }
}