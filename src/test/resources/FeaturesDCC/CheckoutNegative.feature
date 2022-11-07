Feature: Checkout Negative

  Scenario: The user can’t checkout an empty cart

    Given The user is logged in
    When The user clicks on cart symbol
    Then The user can’t checkout no products