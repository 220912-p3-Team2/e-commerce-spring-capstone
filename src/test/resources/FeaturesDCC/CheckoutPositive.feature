Feature: Checkout Positive

  Scenario: The user checks out items in their cart

    Given The user is on the search product page
    Given The user adds some products into the cart
    When The user clicks on cart symbol
    When The user clicks on checkout
    Then The user successfully orders items



  Scenario: The user removes product on checkout page

    Given The user is on the search product page
    Given The user adds some products into the cart
    When The user clicks on cart symbol
    When The user clicks on checkout
    When The user removes item on checkout page
    Then The user should see the product gone from the cart