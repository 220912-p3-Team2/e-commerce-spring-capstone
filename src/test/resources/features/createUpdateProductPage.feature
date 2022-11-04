Feature: Create/Update Products

Scenario: Admin Creates Product
  Given the user is logged in as admin
  When the user clicks on EDIT PRODUCTS
  When the user clicks on CREATE NEW PRODUCT
  When the user types "" into Product Name input
  When the user types "" into Product Description input
  When the user types "" into Image URL
  When the user types "" into Product Price input
  When the user clicks the Create Product button
  Then ((placeholder))