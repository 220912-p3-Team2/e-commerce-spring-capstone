Feature: Checkout Negative

  Scenario: The user can’t checkout an empty cart

    Given The user is logged in
    When The user clicks on cart symbol
    Then The user can’t checkout no products


  Scenario: The user tries to buy an out of stock product

    Given The user is logged in
    When The user adds an out of stock product into the cart
    When The user clicks on cart symbol
    When The user clicks on checkout
    When The user types in information for Shipping Address
    When The user clicks Next
    When The user chooses payment method
    When The user clicks Submit Payment
    When The user clicks Place Order
    Then The user should not be able to successfully buy the out of stock product