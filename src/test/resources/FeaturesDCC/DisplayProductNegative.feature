Feature: Display Product Negative

  Scenario: The user does not see displayed product list

    Given The user is logged in
    When The user is on the product list page
    Then The user should not see product list