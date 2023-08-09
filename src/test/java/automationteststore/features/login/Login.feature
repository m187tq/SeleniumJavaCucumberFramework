@Login
Feature: Login Page - Login Functionality

  Background: common steps in scenarios
    Given I am in Ecommerce home Page "https://automationteststore.com/"
    And I navigate to login page
    And I can see "Returning Customer" and "I am a new customer." sub headings texts

  @LoginPositive @Login
  Scenario Outline: user should be able to login with valid credentials
    And I login "<loginName>" and "<password>"
    And I tap on Login button
#    And I login as a returning customer
#      | datastudioplace | Manchester1 |
    Then should be presented with the following validation message as "<loginValidationMessage>"
    And I tap on edit profile button
    And inputted the following details
      | firstName | lastName | telephone    | fax          |
      | James     | Bond     | 213-233-3340 | 213-233-3341 |
    And clicks on Continue button
    And I should see confirmation message "Success: Your account has been successfully updated."
    When I clicks on logoff button
    And I tap logout Continue Button
    Then I am taken back to home page url "https://automationteststore.com/" and page title as "A place to practice your automation skills!"

    Examples:
      | loginName       | password    | loginValidationMessage |
      | datastudioplace | Manchester1 | Welcome back           |

  @Login_Both @Login
  Scenario Outline: User should NOT be able to login with invalid credentials
    And I login "<loginName>" and "<password>"
    And I tap on Login button
    Then should be presented with the following Error validation message as "<loginValidationErrorMessage>"

    Examples:
      | loginName       | password      | loginValidationErrorMessage                  |
      | WrongLoginName  | Manchester1   | Error: Incorrect login or password provided. |
      | datastudioplace | WrongPassword | Error: Incorrect login or password provided. |
      | WrongLoginName  | WrongPassword | Error: Incorrect login or password provided. |
      |                 |               | Error: Incorrect login or password provided. |
      | datastudioplace |               | Error: Incorrect login or password provided. |
      |                 | Manchester1   | Error: Incorrect login or password provided. |