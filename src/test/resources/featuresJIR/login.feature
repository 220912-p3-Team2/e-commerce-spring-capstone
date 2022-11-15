Feature: Login
  Background: User Is At The Login Page
    Given The user navigates to the login screen.

  Scenario Outline: Login Negative
    When The user attempts to login with the incorrect login credentials."<username>""<password>"
    Then The user sees an alert that says, Login was unsuccessful because your account has been deactivated!"<message>"
    Then The alert closes without any further user input.

    Examples:
      |username|password|message|
      |invalidCredentials@test.net|invalidCredentials|Login was unsuccessful because your account has been deactivated!|

  Scenario Outline: Login Positive
    When The user attempts to login with the correct login credentials."<username>""<password>"
    Then The users is logged in.
    When the user clicks the logout button.
    Then the user is logged out.

    Examples:
      |username|password|
      |test@test.test|7est!nCj|