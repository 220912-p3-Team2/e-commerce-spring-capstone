Feature: Display Products Positive

  Scenario Outline:  The user can search for products
    Given The user is logged in
    When The user is on the search for products page
    Then The user should see all the products available
    When The user types '<Product>' in search bar
    Then The user sees '<Product Title>'

    Examples:
      | Product | Product Title |
      | yoyo | YoYo       |
      | Computer | Computer       |
