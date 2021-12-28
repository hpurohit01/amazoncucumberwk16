Feature: Select Menu Test
  As a user I should be able to select menu

 # @smoke
  Scenario:user  should  able to select menu from menu bar
    Given I am on homepage
    When I select customer service menu
    Then I should be on customer service page