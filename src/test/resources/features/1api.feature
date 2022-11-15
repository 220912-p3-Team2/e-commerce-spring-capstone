Feature: API Tests
  Scenario: auth/lgoin positive
    Then A positive auth/lpgin test is performed.
  Scenario: auth/login negative
    Then A negative auth/login test is performed.
  Scenario: /user Register
    Then A /user Register test is performed.
  Scenario: /user Update
    Then A /user Update test is performed.
  Scenario: /api/payment Update
    Then A /api/payment createPayment test is performed.
  Scenario: /api/payment Delete
    Then A /api/payment deletePayment test is performed.
  Scenario: /user/deactivate Positive
    Then A positive /user/deactivate test is performed.