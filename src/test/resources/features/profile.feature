Feature: Profile
  Background:
    Given The user is logged into their account and on the profile page.

  Scenario Outline: Update Your Profile
    When The user enters a new first name, last name, and password. "<fname>""<lname>""<pword>"
    When The user clicks the, UPDATE button.
    Then The user will see an alert that says, You've successfully updated your profile!"<message>"

    Examples:
    |fname|lname|pword|message|
    |testing|testing| |You've successfully updated your profile!|

  Scenario Outline: Add New Payment Option
    When The user enter new payment information. "<cardNumber>""<expirationDate>""<cvv>"
    When the user clicks the, ADD PAYMENT button.
    Then The user will see an alert that says, You've successfully added your payment method!"<message>"

    Examples:
    |cardNumber|expirationDate|cvv|message|
    |1234567887654321|12/12/2022|123|You've successfully added your payment method!|

  Scenario Outline: Delete Payment Option
    When The user clicks the, DELETE button.
    Then the user will see an alert that says, You've successfully removed your payment method!"<message>"
    Examples:
    |message|
    |You've successfully removed your payment method!|

  Scenario Outline: Deactivate Your Account
    When The user enters the token into the deactivate field."<token>"
    When The user click the, DEACTIVATE button.
    Then the user is logged out and redirected to the sign in page.

    Examples:
    |token|
    |deactivate|