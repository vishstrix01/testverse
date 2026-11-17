package com.testverse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartList = By.className("cart_list");
    private final By itemNames = By.className("inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getItemNames() {
        waitForVisible(cartList);
        // Retry automatically if the page re-renders while we read the text
        return wait.ignoring(StaleElementReferenceException.class)
                .until(d -> d.findElements(itemNames).stream()
                        .map(WebElement::getText)
                        .toList());
    }

    public CheckoutPage checkout() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}