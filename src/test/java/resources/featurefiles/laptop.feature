Feature:Amazon homepage laptop search

  As a user I should be able to search laptop and add them to cart

@smoke
  Scenario:user is able to search laptop and add it to cart successfully

    Given I am on homepage
    When I search for "laptop"
    And I click on search button
    And I search for item from pages "2020 Newest HP Stream 11.6 inch HD Laptop, Intel Celeron N4000, 4 GB RAM, 64 GB eMMC, Webcam, HDMI, Windows 10"
    And I update the quantity "3"
    And I click on add to cart button
    Then I should be able to verify add to cart message "Added to cart"
