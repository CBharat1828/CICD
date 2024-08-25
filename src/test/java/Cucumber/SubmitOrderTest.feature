
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file


Background: 
Given I landed on Ecommerce Page

 
  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <email> and password <password>
    When I added the product <productName> to cart
    And CheckOut <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | email                | password   | productName  |
      | bharat1234@gmail.com | Bharat@1234| ZARA COAT 3  |
      
