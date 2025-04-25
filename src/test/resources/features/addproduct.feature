Feature: Add product to cart


  # TCC_HR_005
  Scenario: Adding product to the cart
    Given The user is logged in
    When The user adds the Sauce Labs Bike Light product to the cart
    And The cart badge should display one item
    And The user click the shopping cart icon
    Then The user should be redirected to the cart page
    And The cart page should display the Sauce Labs Bike Light product







