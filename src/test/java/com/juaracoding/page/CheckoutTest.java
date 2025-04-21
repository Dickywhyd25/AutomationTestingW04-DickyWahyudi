package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private WebDriver driver;

    public void scrollTo(int upTo) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll({\r\n" + //
                "  top: " + upTo + ",\r\n" + //
                "  behavior: \"smooth\",\r\n" + //
                "});");
    }

    @BeforeClass
    public void init(){
        driver = com.juaracoding.DriverSingleton.getDriver();
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void klikKeranjang () throws InterruptedException{
        Thread.sleep(1000);
        inventoryPage.goToCart();
    }

    @Test(priority = 2)
    public void checkoutKeranjang() throws InterruptedException{
        scrollTo(700);
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cartPage.getCartText();
    }

}
