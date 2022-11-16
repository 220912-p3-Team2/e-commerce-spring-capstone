Feature: Search for Products

  Background:
    Given A user is on the main paige

  Scenario: Exact Search
    When the user types the exact name of a product into the search bar
    Then A product with the same name should be among listed products shown

  Scenario: Zero Result Search
    When the user types a string that is not contained by any product name
    Then there should be zero listed products shown

  Scenario: Multiresult Search
    When the user types a string that matches multiple products
    Then there should be more than zero listed products shown