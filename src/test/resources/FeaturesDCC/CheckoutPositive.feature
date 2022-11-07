Feature: Checkout Positive

  Scenario: The user checks out items in their cart

    Given The user is logged in
    Given The user adds a product to cart
    When The user clicks on cart symbol
    When The user clicks on checkout
    When The user types in information for Shipping Address
    When The user clicks Next
    When The user chooses payment method
    When The user clicks Submit Payment
    When The user clicks Place Order
    Then The user successfully ordered items



#  Scenario: The user tries to buy an out of stock product
#
#    Given The user is logged in
#    Given The user adds an out of stock product into the cart
#    When The user clicks on cart symbol
#    When The user clicks on checkout
#    When The user removes item on checkout page
#    Then The user should see the product gone from the cart