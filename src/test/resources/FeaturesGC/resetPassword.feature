Feature: Password Reset
  When the user clicks Reset Password
  When the user enters their email
  When the user clicks Send Password Reset Link
  When the user follows the reset link
  When the user enters a new password and clicks Submit
  When the user attempts to log in using the new credentials
  Then the user should be logged in

  ##Requires SMTP server to test