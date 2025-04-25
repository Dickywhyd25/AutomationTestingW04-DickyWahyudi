package com.juaracoding.stepdefinitions;

import com.juaracoding.Hook;
import com.juaracoding.page.CartPage;
import com.juaracoding.page.LoginPage;
import com.juaracoding.page.ProductPage;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class AddProductSteps {

    private static WebDriver driver;
    private static ExtentTest extentTest;

    private static final LoginPage loginPage = new LoginPage();
    private static final ProductPage productPage = new ProductPage();
    private static final CartPage cartPage = new CartPage();

    public AddProductSteps() {
        driver = Hook.driver;
        extentTest = Hook.extentTest;
    }

    // TCC.HR.005

    @Given("The user is logged in")
    public void the_user_is_logged_in() {
        driver.get(Constants.URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS, "User successfully logged in");
    }

    @When("The user adds the Sauce Labs Bike Light product to the cart")
    public void the_user_adds_the_sauce_labs_bike_light_product_to_the_cart() throws InterruptedException {
        productPage.addProductsToCart(List.of("Bike Light"));
        extentTest.log(LogStatus.PASS, "User adds 'Sauce Labs Bike Light' to cart");
    }

    @And("The cart badge should display one item")
    public void the_cart_badge_should_display_one_item() {
        Assert.assertEquals(productPage.getShoppingCartBadge(), "1");
        extentTest.log(LogStatus.PASS, "Cart badge displays 1 item");
    }

    @And("The user click the shopping cart icon")
    public void the_user_click_the_shopping_cart_icon() {
        productPage.clickShoppingCart();
        extentTest.log(LogStatus.PASS, "User clicks the shopping cart icon");
    }

    @Then("The user should be redirected to the cart page")
    public void the_user_should_be_redirected_to_cart_page() {
        Assert.assertEquals(cartPage.getYourCart(), "Your Cart");
        extentTest.log(LogStatus.PASS, "User is on the cart page");
    }

    @And("The cart page should display the Sauce Labs Bike Light product")
    public void the_cart_page_should_display_the_sauce_labs_bike_light_product() {
        List<String> productNames = cartPage.getAllProductNamesInCart();/////
        Assert.assertEquals(cartPage.getProductName(), "Sauce Labs Bike Light");
        extentTest.log(LogStatus.PASS, "Cart page displays correct item");
    }


}


