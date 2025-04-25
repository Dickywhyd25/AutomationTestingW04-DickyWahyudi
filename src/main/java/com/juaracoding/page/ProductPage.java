package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    private WebDriver driver;

    public ProductPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement products;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCart;

    public String getProducts() {
        return products.getText();
    }

    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public void addProductsToCart(List<String> productNames) throws InterruptedException {
        for (String name : productNames) {
            String formattedName = name.toLowerCase().replaceAll(" ", "-");
            String id = "add-to-cart-sauce-labs-" + formattedName;
            WebElement button = driver.findElement(By.id(id));
            button.click();
            Thread.sleep(1000);
        }
    }
}

