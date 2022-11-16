Feature: Product Reviews

  Scenario: User is Logged In
    Given the user is logged in
    Given the user is in a product's details
    When the user selects a product
    When the user interacts with the rating stars
    When the user adds a review body
    When the user clicks the submit button
    Then the user should see the review listed

  Scenario: User is not Logged In
    Given the user is not logged in
    Given the user is in a product's details
    When the user selects a product
    When the user interacts with the rating stars
    When the user adds a review body
    When the user clicks the submit button
    Then the user should see no change

  Scenario: User removes there own review
    Given the user is logged in
    Given the user is in a product's details that they reviewed
    When the user clicks the delete button
    Then the review should no longer be listed