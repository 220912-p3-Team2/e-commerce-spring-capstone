Feature: Create/Update Products

Scenario: Admin Creates Product
  Given the user is logged in as admin
  When the user clicks on EDIT PRODUCTS
  When the user clicks on CREATE NEW PRODUCT
  When the user types "Diploma" into Product Name input
  When the user types "Congratulations on your newly-learned skills" into Product Description input
  When the user types "https://images2.imgbox.com/e1/1e/qLiskew5_o.jpg" into Image URL
  When the user types "9.99" into Product Price input
  When the user clicks the Create Product button
  Then the new product should be visible on the Products page

Scenario: Admin Updates Product Information
  When the user clears the Product Price input
  When the user types "99.99" into  the edit Product Price input
  When the user clicks the UPDATE button
  Then the product should update with the new price

Scenario: Update Product Negative
  When the user clears all input fields
  When the user clicks the UPDATE button
  Then the product should fail to update

Scenario: Delete Product
  When the user clicks the DELETE button
  Then the product should no longer be visible

Scenario: Create Product Negative
  When the user clicks on CREATE NEW PRODUCT
  When the user clicks the Create Product button
  Then no new product should be created