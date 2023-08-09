Feature: Verification of Contactus functionality

  Background: common steps
    Given I navigate to contactus page
    And should see company contact details are displayed "012345 6781199"

  @contactusNegative
  Scenario: should not be able to submit a message in contactus form with blank fields

    When I inputted first name as " " email Address as " " and inquiry as " "
    And  clicks on the submit button
    Then I should get confirmation warning massage firstname  "First name: is required field! Name must be between 3 and 32 characters!"
    Then I should get confirmation warning massage email "Email: is required field! E-Mail Address does not appear to be valid!"
    Then I should get confirmation warning massage inquiry "Enquiry: is required field! Enquiry must be between 10 and 3000 characters!"

  @contactusNegative
  Scenario: user should not be able to submit a message in contactus form with invalid email
    When I inputted first name as "John" email Address as "email" and inquiry as "My message body"
    And  clicks on the submit button
    Then I should get confirmation warning massage firstname  "First name: is required field! Name must be between 3 and 32 characters!"
    Then I should get confirmation warning massage email "Email: is required field! E-Mail Address does not appear to be valid!"
    Then I should get confirmation warning massage inquiry "Enquiry: is required field! Enquiry must be between 10 and 3000 characters!"


    