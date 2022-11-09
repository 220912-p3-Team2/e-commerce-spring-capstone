Feature: Cart

  Scenario: The user adds products to cart

    Given The user is logged in
    When The user adds a product to cart
    When The user clicks on cart symbol
    Then The user sees added product

  Scenario: The user removes products from cart

    Given The user is logged in
    When The user adds a product to cart
    When The user clicks on cart symbol
    When The user removes product
    Then The user sees the product removed from cart