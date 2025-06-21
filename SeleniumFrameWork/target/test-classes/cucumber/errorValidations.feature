
@tag
Feature: Error Valdation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Positive Test of Submitting the Order
    Given I landed on Eccomerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  						| password 	  | productName			|
      | dnss@gmail.com  	| Password1   | ZARA COAT 3     |
      | anshika@gmail.com | Iamking@00  | ADIDAS ORIGINAL |
