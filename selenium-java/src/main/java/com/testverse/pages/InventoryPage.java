package com.testverse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return getText(pageTitle);
    }

    // productSlug example: "sauce-labs-backpack"
    public InventoryPage addToCart(String productSlug) {
        click(By.id("add-to-cart-" + productSlug));
        return this;
    }

    public InventoryPage removeFromCart(String productSlug) {
        click(By.id("remove-" + productSlug));
        return this;
    }

    public int getCartCount() {
        var badges = driver.findElements(cartBadge);
        return badges.isEmpty() ? 0 : Integer.parseInt(badges.get(0).getText());
    }

    public CartPage openCart() {
        click(cartLink);
        return new CartPage(driver);
    }
}
