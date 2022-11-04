Feature: Display Product Negative

  Scenario: The user does not see displayed searched product

    Given The user is logged in
    When The user types in a nonexistent product in search bar
    Then The user should not see the product