Feature: Product Details View

  Background:
    Given the user is on the main page

  Scenario: Product Has a Dialog Box Description
    When the user clicks on a product details button
    Then the user should see a dialog
    Then the user should see an image, price, description, and reviews

  Scenario: Product has a product page
    When the user clicks on a product details button
    When the user clicks on the expand button
    Then the user is navigated to the product page
    Then the user should see an image, price, description, and reviews on the page
