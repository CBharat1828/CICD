
@tag
Feature: Error Validation
  I want to use this template for my feature file

 

  @ErrorValidation
  Scenario Outline: Negative Test for loggingIn
    Given I landed on Ecommerce Page
    When  Logged in with username <email> and password <password>
    Then "Incorrect email or password." message is displayed on the landingPage

    Examples: 
      | email                | password  | 
      | bharat1234@gmail.com | Bharat1234| 
      
