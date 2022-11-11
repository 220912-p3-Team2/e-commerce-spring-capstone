Feature: Product Details View

  Scenario: Product Has a Description
    Given The user is on the main page
    When the user clicks on a product details button
    Then the user should see an image, price, description, and reviews