package com.juaracoding.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    public Actions actions;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginAction(String username, String password) {
        actions.click(usernameField).sendKeys(username)
                .pause(Duration.ofSeconds(1))
                .click(passwordField).sendKeys(password)
                .pause(Duration.ofSeconds(1))
                .moveToElement(loginButton).click().build().perform();
    }

}
