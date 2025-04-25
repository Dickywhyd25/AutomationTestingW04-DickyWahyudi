package com.juaracoding.stepdefinitions;

import com.juaracoding.Hook;
import com.juaracoding.page.LoginPage;
import com.juaracoding.page.ProductPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {

    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static final LoginPage loginPage = new LoginPage();
    private static ProductPage productPage = new ProductPage();

    public LoginSteps() {
        driver = Hook.driver;
        extentTest = Hook.extentTest;
    }


    @Given("The user is on the login page with invalid credentials")
    public void the_user_is_on_the_login_page_with_invalid_credentials() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "The user is on the login page with invalid credentials");
    }

    @When("The user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        loginPage.login("fake_user", "wrong_pswd");
        extentTest.log(LogStatus.PASS, "The user enters an invalid username and password");

    }

    @Then("The error message for invalid credentials should be displayed")
    public void the_error_message_for_invalid_credentials_should_be_displayed() {
        String errorMessage = loginPage.getErrorMessage(LoginPage.NOT_MATCH);
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS, "The error message for invalid credentials is displayed");
    }

    @Given("The user is on the login page with empty username")
    public void the_user_is_on_the_login_page_with_empty_username() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "The user is on the login page with empty username");
    }

    @When("The user enters an empty username and a valid password")
    public void the_user_enters_an_empty_username_and_a_valid_password() {
        loginPage.login("", "secret_sauce");
        extentTest.log(LogStatus.PASS, "The user enters an empty username and a valid password");
    }

    @Then("The error message for empty username should be displayed")
    public void the_error_message_for_empty_username_should_be_displayed() {
        String errorMessage = loginPage.getErrorMessage(LoginPage.EMPTY_USERNAME);
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required");
        extentTest.log(LogStatus.PASS, "The error message for empty username is displayed");
    }

    @Given("The user is on the login page with empty password")
    public void the_user_is_on_the_login_page_with_empty_password() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "The user is on the login page with empty password");
    }

    @When("The user enters a valid username and an empty password")
    public void the_user_enters_a_valid_username_and_an_empty_password() {
        loginPage.login("standard_user", "");
        extentTest.log(LogStatus.PASS, "The user enters a valid username and an empty password");
    }

    @Then("The error message for empty password should be displayed")
    public void the_error_message_for_empty_password_should_be_displayed() {
        String errorMessage = loginPage.getErrorMessage(LoginPage.EMPTY_PASSWORD);
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required");
        extentTest.log(LogStatus.PASS, "The error message for empty password be displayed");
    }

    @Given("The user is on the login page")
    public void The_user_is_on_the_login_page() {
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS, "The user is on the login page");
    }

    @When("The user enters a valid username and password")
    public void the_users_enter_a_valid_username_and_password() {
        loginPage.login("standard_user", "secret_sauce");
        extentTest.log(LogStatus.PASS, "The user enters a valid username and password");
    }

    @And("The user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS, "The user clicks the login button");
    }

    @Then("The user should be redirected to the product page")
    public void the_user_should_be_redirected_to_product_page() {
        String pageTitle = productPage.getProducts();
        Assert.assertEquals(pageTitle, "Products");
        extentTest.log(LogStatus.PASS, "The user is redirected to the product page");
    }

}