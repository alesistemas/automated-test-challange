Feature: User Login
  Pre condition : Visit Main Page (made in the runner)

  Background:
    Given   the user visit the homepage
    When    the user click on the enter or register link

  @e2e-test @loginTest @successLoggedInAndLogout
  Scenario: User Login
    And     the user fill the email field
    And     the user fill the password field
    And     the user click on the continue button
    Then    the user is logged in
    When    the user click on your menu and then click on the logout link
    Then    the user is logged out and cannot see your account details

  @e2e-test @loginTest @invalidLogin @emptyFields @bb
  Scenario: Login with empty username and/or password
    And     the user click on the continue button
    Then    a warning message saying that the email and or password are required is presented to the user

  @e2e-test @loginTest @invalidLogin @invalidFields
  Scenario: Login with invalid username and/or password
    And     the user enters with your email and or password with invalid values
    And     the user click on the continue button
    Then    the user will not be successfully logged in
    And     a warning message saying that incorrect username or password is presented to the user