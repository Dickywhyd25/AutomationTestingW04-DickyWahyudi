package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private WebDriver driver;


    @BeforeClass
    public void init() {
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);

        inventoryPage = new InventoryPage(driver);

        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Parameters({ "username", "password" })
    public void loginTest(String username, String password) {
        loginPage.loginAction(username, password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String actual = inventoryPage.getProductLabel();
        String expected = "Sauce Labs Backpack";
        Assert.assertEquals(actual, expected);
    }
}
