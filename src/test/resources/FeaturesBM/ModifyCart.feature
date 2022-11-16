Feature: Modify Cart

  Scenario: The user adds products to cart and changes quantity
    Given user is logged in and on the product page
    When The user adds a product to cart
    When The user clicks on cart symbol
    Then The user sees added product

  Scenario: The user removes products from cart
    Given user is logged in and on the product page again
    When The user adds a product to cart again
    When The user clicks on cart symbol again
    When The user removes product
    Then The user sees the product removed from cart

  Scenario: The user changes quantity of products in cart
    Given The user is on cart page with product in cart
    When The user changes quantity of the product
    Then The user sees updated quantity
