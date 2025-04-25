Feature: Login

  # TCC.HR.001
  Scenario: Login failed with invalid credentials
    Given The user is on the login page
    When The user enters an invalid username and password
    And The user clicks the login button
    Then The error message for invalid credentials should be displayed

  # TCC.HR.002
  Scenario: Login with empty username
    Given The user is on the login page
    When The user enters an empty username and a valid password
    And The user clicks the login button
    Then The error message for empty username should be displayed

  # TCC.HR.003
  Scenario: Login with empty password"
    Given The user is on the login page
    When The user enters a valid username and an empty password
    And The user clicks the login button
    Then The error message for empty password should be displayed

  # TCC.HR.004
  Scenario: Login successful with valid credentials"
    Given The user is on the login page
    When The user enters a valid username and password
    And The user clicks the login button
    Then The user should be redirected to the product page
