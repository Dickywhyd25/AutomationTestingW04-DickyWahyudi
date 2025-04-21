package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryPageTest {
    private InventoryPage inventoryPage;
    private WebDriver driver;

    @BeforeClass
    public void init(){
        driver = DriverSingleton.getDriver();
        inventoryPage = new InventoryPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        inventoryPage.addToCart(0);
        Thread.sleep(1000);
        inventoryPage.addToCart(1);
        Thread.sleep(1000);
        inventoryPage.addToCart(2);
        Thread.sleep(1000);
        inventoryPage.addToCart(3);
        Thread.sleep(1000);
        inventoryPage.addToCart(4);
        Thread.sleep(1000);
        inventoryPage.addToCart(5);
        Thread.sleep(1000);
    }

    @Test(priority = 2)
    public void verifyCartCount(){
        Assert.assertEquals(inventoryPage.getShoppingCartBadge(),"6");
    }


}

