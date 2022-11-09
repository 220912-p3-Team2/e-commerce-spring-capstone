Feature: Checkout Positive

  Scenario: The user checks out items in their cart

    Given The user is logged in
    When The user adds a product to cart
    When The user clicks on cart symbol
    When The user clicks on checkout
    When The user types in information for Shipping Address
    When The user clicks Next
    When The user chooses payment method
    When The user clicks Submit Payment
    When The user clicks Place Order
    Then The user successfully ordered the products



