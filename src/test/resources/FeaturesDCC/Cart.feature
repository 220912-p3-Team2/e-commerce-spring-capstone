Feature: Cart

  Scenario: The user adds products to cart

    Given The user is logged in
    When The user adds a product to cart
    When The user clicks on cart symbol
    Then The user sees added product

