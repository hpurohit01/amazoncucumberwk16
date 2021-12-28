Feature: Amazon Homepage search mobile test

  As a user I should be able to search mobile and add them to cart

  @smoke
  Scenario:user is able to search mobile and add it to cart successfully
    Given I am on homepage
    When I search for "mobile phone"
    And I click on search button
    And I search for item from pages "Samsung Galaxy S10, 128GB, Prism White - Unlocked (Renewed)"
    And I update the quantity "3"
    And I click on add to cart button
    Then I should be able to verify add to cart message "Added to cart"
