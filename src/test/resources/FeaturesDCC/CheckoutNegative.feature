Feature: Checkout Negative

  Scenario: The user can’t checkout no products

    Given The user is on the search product page
    When The user clicks on the cart symbol
    Then The user can’t checkout no products