@login
Feature: Login Functionality

  Scenario: Successful login
    Given I am on home page
    When I open the login page
    When I enter username
    And I enter password
    And I click the login button
    Then I should be logged in successfully

  Scenario: Login form validations
    Given I am on home page
    When I open the login page
    And I validate required field validation for all fields on Login Page
    And I validate the login form fields
    |  Email         | Password  |
    | email          | email     |
    | email@         | email     |
    | email@mail     | email     |
    | email@mail.    | email     |
    | email@mail.com | email     |