       package com.juaracoding.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    @FindBy(className = "inventory_item_name")
    private WebElement productLabel;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(className = "btn_inventory")
    private List<WebElement> btnInventories;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement pathCart;



    public InventoryPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public String getProductLabel() {

        return productLabel.getText();
    }

    public String getShoppingCartBadge(){

        return shoppingCartBadge.getText();
    }

    public void addToCart(int index){

        btnInventories.get(index).click();
    }

    public void goToCart() {
        pathCart.click();
    }

}
