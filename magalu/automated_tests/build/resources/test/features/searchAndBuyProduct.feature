Feature: Search and Buy a Product
  Pre condition : Visit Main Page (made in the runner)

  Background:
    Given   the user visit the homepage

  @e2e-test @searchProduct
  Scenario: Search for a product
    And     the user fill the search field to search for a product

  @e2e-test @SearchAndBuyProduct @buyProduct
  Scenario: Buy a product
    And     the user fill the search field to search for a product
    And     the user click on buy product
    And     the user fill the email field
    And     the user fill the password field
    And     the user click on the continue button
    Then    the user is directed to the delivery options page and the user click on the delivery continue button
    Then    the user is directed to the payment page