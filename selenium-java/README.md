# Selenium Java Test Automation Framework

UI test automation framework for the [SauceDemo](https://www.saucedemo.com) e-commerce demo site, built with Java, Selenium WebDriver and TestNG using the Page Object Model.

## Tech Stack

- Java 17
- Selenium WebDriver 4.27
- TestNG 7.10
- Maven
- Page Object Model design pattern

## Project Structure

```
selenium-java/
├── pom.xml
└── src/
    ├── main/java/com/testverse/pages/
    │   ├── BasePage.java        # shared waits and actions
    │   ├── LoginPage.java
    │   ├── InventoryPage.java
    │   ├── CartPage.java
    │   └── CheckoutPage.java
    └── test/
        ├── java/com/testverse/
        │   ├── base/BaseTest.java       # browser setup and teardown
        │   └── tests/
        │       ├── LoginTest.java
        │       ├── CartTest.java
        │       └── CheckoutTest.java
        └── resources/testng.xml         # test suite definition
```

## Test Coverage

| Area     | Tests | What is verified |
|----------|-------|------------------|
| Login    | 4     | valid login, wrong password, locked-out user, empty username |
| Cart     | 3     | add item, remove item, cart page lists added items |
| Checkout | 1     | end-to-end purchase with confirmation message |

## Design Highlights

- **Page Object Model:** each page has its own class, so a UI change is fixed in one place.
- **Explicit waits:** `BasePage` wraps all clicks and typing in waits, which avoids flaky tests.
- **Test base class:** `BaseTest` starts a fresh Chrome session before each test and closes it afterwards, so tests are independent.
- **No manual driver setup:** Selenium Manager downloads the matching Chrome driver automatically.

## How to Run

Prerequisites: JDK 17, Maven and Google Chrome.

```bash
git clone https://github.com/vishstrix01/testverse.git
cd testverse/selenium-java
mvn test
```

## Author

Vishal Parvatikar