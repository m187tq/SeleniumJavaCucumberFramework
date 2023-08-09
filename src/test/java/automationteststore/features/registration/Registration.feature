
Feature: Verification of Registration functionality

  Background: common steps in scenarios
    Given I am in Ecommerce home Page "https://automationteststore.com/"
    And I navigate to login page
    And I can see "Returning Customer" and "I am a new customer." sub headings texts
    And I click Continue button in account login page
    And I can see page title as "Create Account" and heading text as "CREATE ACCOUNT"
    And I should see the create account form
    And I can see input sections as "Your Personal Details", "Your Address", "Login Details" and "Newsletter"
    #And I can see labels as 16 as first label as "First Name:" and last as "Subscribe:"

  Scenario: I should be able to Register with valid credentials
    And I input firstName as "FirstName"
    And I input lastName as "LastName"
    And I input emailAddress
    And I input telephone as "074000000000"
    And I input fax as "074000000001"
    And I input company as "Company Ltd"
    And I input Address one as "1 Address Street"
    And I input Address two as "Gorton South"
    And I input city as "Manchester"
    And I select region or province "Lancashire"
    And I input zipCodeOrPostCode as "M18 7QT"
    And I select "United Kingdom" country from the dropdown
    And I input unique loginName
    And I input password as "password@123"
    And I input confirm password as "password@123"
    And I can see subscription option "Yes"
    And I tick on subscription option Yes
    And I tick on "Privacy Policy" radio button
    And I can see "Continue" button
    And I tap on Continue button
    Then I should see "YOUR ACCOUNT HAS BEEN CREATED!" in Account success page
    And I tap on Continue button in Account success page
    And I can see "Dashboard" and "Welcome back" in account page
    And I am on Account page and presented with welcome message "Welcome back"
    And I clicks on logoff button
    And I clicks on logout Continue Button
    And I am taken back to home page url "https://automationteststore.com/" and page title as "A place to practice your automation skills!"

  Scenario: Registration with blank - verify compulsory fields
    When I tap on Continue button in create account page
    Then I should see red warning error message "Error: You must agree to the Privacy Policy!"
    And I can see "First Name" must be between "1" and "32" characters
    And I should see "Last Name" must be between "1" and "32" characters!
    And I can see "Email Address" does not appear to be valid!
    And I should see "Address 1" must be between "3" and "128" characters
    And I see "City" must be between "3" and "128" characters!
    And I can see "Please select" a region state
    And Then I see "Zip/postal code" must be between "3" and "10" characters!
    And I can see "Login name" must be alphanumeric only and between "5" and "64" characters!
    And seeing "Password" must be between "4" and "20" characters
    And I should see 11 mandatory red icons

  @RegistrationFunctionality
  Scenario: Registration with blank - verify compulsory fields
    When I tick on read and agree to the Privacy Policy
    And I tap on Continue button in create account page
    #Then I should see red warning error message "Error: You must agree to the Privacy Policy!"
    And I can see "First Name" must be between "1" and "32" characters
    And I should see "Last Name" must be between "1" and "32" characters!
    And I can see "Email Address" does not appear to be valid!
    And I should see "Address 1" must be between "3" and "128" characters
    And I see "City" must be between "3" and "128" characters!
    And I can see "Please select" a region state
    And Then I see "Zip/postal code" must be between "3" and "10" characters!
    And I can see "Login name" must be alphanumeric only and between "5" and "64" characters!
    And seeing "Password" must be between "4" and "20" characters
    And I should see 11 mandatory red icons
    And I can see list of red error warning messages are displayed