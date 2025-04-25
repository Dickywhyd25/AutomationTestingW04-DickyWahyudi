package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement yourCart;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadge;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement productName;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productNames;

    public String getShoppingCartBadge() {
        return shoppingCartBadge.getText();

    }


    public String getYourCart() {
        return yourCart.getText();
    }

    public String getProductName() {
        return productName.getText();
    }

    public List<String> getAllProductNamesInCart() {
        List<String> productList = new ArrayList<>();

        for (WebElement product : productNames) {
            productList.add(product.getText());
        }

        return productList;
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}

