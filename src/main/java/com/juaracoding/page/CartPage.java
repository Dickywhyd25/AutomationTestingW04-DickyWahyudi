package com.juaracoding.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = " //span[@class='title']" )
    private WebElement textCartPage;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getCartText () {
        return textCartPage.getText();
    }

}

