package com.testverse.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String URL = "https://www.saucedemo.com/";

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);
        return this;
    }

    public InventoryPage loginAs(String username, String password) {
        enterCredentials(username, password);
        return new InventoryPage(driver);
    }

    public LoginPage loginExpectingFailure(String username, String password) {
        enterCredentials(username, password);
        return this;
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    private void enterCredentials(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
}