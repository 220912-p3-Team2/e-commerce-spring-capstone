Feature: Register

  Background:
    Given The user is on the register page.

  Scenario Outline: Negative Registration
    When The user clicks the sign up button.
    Then The user sees an alert that says, Please fill out this field."<message>"
    When The user enters registration information excluding a password."<fname>""<lname>""<email>"
    When The user clicks the sign up button.
    Then The user sees an alert that says, Please fill out this field."<message>"
    When The user enters an invalid password."<password>"
    When The user clicks the sign up button.
    Then The user sees an alert that says, Please fill out this field."<message>"

    Examples:
    |message|fname|lname|email|password|
    |First Name is required|invalid|invalid|invalid@invalid.invalid|invalid|


  Scenario Outline: Positive Registration
    When The user enters valid registration data."<fname>""<lname>""<email>""<password>"
    When The user clicks the sign up button.
    Then The user is moved to the sign in page.

    Examples:
    |fname|lname|email|password|
    |test |test |test@test.test|7est!nCj|