package com.juaracoding.page;

import com.juaracoding.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;
    public static final String NOT_MATCH = "not_match";
    public static final String EMPTY_USERNAME = "empty_username";
    public static final String EMPTY_PASSWORD = "empty_password";

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement Products;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageNotMatch;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageEmptyUsername;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageEmptyPassword;

    public void login(String username, String password){
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public String getTxtProducts(){
        return Products.getText();
    }
    public String getErrorMessageNotMatch() {
        return errorMessageNotMatch.getText();
    }
    public String getErrorMessageEmptyUsername() {
        return errorMessageEmptyUsername.getText();
    }
    public String getErrorMessageEmptyPassword() {
        return errorMessageEmptyPassword.getText();
    }
    public String getErrorMessage(String errorType) {
        if (errorType.equals(NOT_MATCH)) {
            return getErrorMessageNotMatch();
        } else if (errorType.equals(EMPTY_PASSWORD)) {
            return getErrorMessageEmptyPassword();
        } else if (errorType.equals(EMPTY_USERNAME)) {
            return getErrorMessageEmptyUsername();
        } else {
            return getErrorMessageNotMatch();
        }
    }
}

