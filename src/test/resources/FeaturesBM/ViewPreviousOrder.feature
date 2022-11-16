Feature: View previous order

  Scenario: A user can view their previous orders
    Given user is logged in and on the home page
    When user clicks on Orders button
    Then user is taken to the orders page where previous orders are displayed
