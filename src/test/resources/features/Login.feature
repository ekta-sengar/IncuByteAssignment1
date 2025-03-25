@login
Feature: Login Functionality

  Scenario: Successful login
    Given I am on home page
    When I open the login page
    When I enter username
    And I enter password
    And I click the login button
    Then I should be logged in successfully