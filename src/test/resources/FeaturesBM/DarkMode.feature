Feature: Dark mode

  Scenario: A user can turn dark mode on and off
    Given user is on the home page and light mode is on
    When user clicks dark mode button
    When user clicks dark mode button again
    Then dark mode is turned on and off
