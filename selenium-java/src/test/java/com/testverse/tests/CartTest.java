package com.testverse.tests;

import com.testverse.base.BaseTest;
import com.testverse.pages.CartPage;
import com.testverse.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    private InventoryPage loginToInventory() {
        return loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void addingItemUpdatesCartBadge() {
        InventoryPage inventory = loginToInventory();
        inventory.addToCart("sauce-labs-backpack");
        Assert.assertEquals(inventory.getCartCount(), 1);
    }

    @Test
    public void removingItemClearsCartBadge() {
        InventoryPage inventory = loginToInventory();
        inventory.addToCart("sauce-labs-backpack").removeFromCart("sauce-labs-backpack");
        Assert.assertEquals(inventory.getCartCount(), 0);
    }

    @Test
    public void cartPageShowsAddedItems() {
        CartPage cart = loginToInventory()
                .addToCart("sauce-labs-backpack")
                .addToCart("sauce-labs-bike-light")
                .openCart();
        Assert.assertEquals(cart.getItemNames(),
                List.of("Sauce Labs Backpack", "Sauce Labs Bike Light"));
    }
}