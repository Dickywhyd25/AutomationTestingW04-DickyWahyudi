Feature: Continue Shopping

  # TCC_HR_006
  Scenario: Continue shopping and add product to cart

    Given The user is on cart page
    Then The user clicks the Continue Shopping button
    Then The user should be redirected to the product page after continue shopping
    And The user adds multiple products to the cart
    And The cart badge should display 3 items
    And The user clicks the shopping cart icon
    Then The user sees the added products in the cart

