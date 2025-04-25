package com.juaracoding.stepdefinitions;

import com.juaracoding.Hook;
import com.juaracoding.page.*;
import com.juaracoding.page.ProductPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class ShoppingSteps {

    private static WebDriver driver;
    private static ExtentTest extentTest;

    private static final CartPage cartPage = new CartPage();
    private static final ProductPage productPage = new ProductPage();

    public ShoppingSteps() {
        driver = Hook.driver;
        extentTest = Hook.extentTest;
    }

    // TCC.HR.006

    @Given("The user is on cart page")
    public void the_user_is_on_cart_page() {
        productPage.clickShoppingCart();
        extentTest.log(LogStatus.PASS, "User is on cart page");
    }

    @Then("The user clicks the Continue Shopping button")
    public void the_user_clicks_the_continue_shopping_button() {
        cartPage.clickContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "User clicks Continue Shopping button");
    }

    @Then("The user should be redirected to the product page after continue shopping")
    public void the_user_should_be_redirected_to_product_page_after_continue_shopping() {
        String pageTitle = productPage.getProducts();
        Assert.assertEquals(pageTitle, "Products");
        extentTest.log(LogStatus.PASS, "The user is redirected to the product page after continue shopping");
    }

    @And("The user adds multiple products to the cart")
    public void the_user_adds_multiple_products_to_the_cart() throws InterruptedException {
        List<String> productsToAdd = Arrays.asList("Fleece Jacket", "Onesie");
        productPage.addProductsToCart(productsToAdd);
        extentTest.log(LogStatus.PASS, "User added multiple products to the cart: " + productsToAdd);
    }

    @And("The cart badge should display {int} items")
    public void the_cart_badge_should_display_items(int expectedCount) {
        String badgeText = productPage.getShoppingCartBadge();
        Assert.assertEquals(Integer.parseInt(badgeText), expectedCount);
        extentTest.log(LogStatus.PASS, "Cart badge displays " + expectedCount + " items");
    }

    @And("The user clicks the shopping cart icon")
    public void the_user_clicks_shopping_cart_icon() {
        productPage.clickShoppingCart();
        extentTest.log(LogStatus.PASS, "User clicks shopping cart icon");
    }

    @Then("The user sees the added products in the cart")
    public void the_user_sees_the_added_products_in_the_cart() {
        List<String> expectedProducts = Arrays.asList(
                "Sauce Labs Bike Light",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie");
        List<String> actualProducts = cartPage.getAllProductNamesInCart();
        for (String product : expectedProducts) {
            Assert.assertTrue(actualProducts.contains(product), "Product not found in cart: " + product);
        }
        extentTest.log(LogStatus.PASS, "All expected products are present in the cart");
    }
}
