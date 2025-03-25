Feature: Register Functionality

  @RegisterFormValidationScenario
  Scenario: Registration form validations
    Given I am on home page
    When I open the register page
    Then I validate required field validation for all fields
    And I validate the registration form fields
    | First Name | Last Name |  Email        | Password    | Password Confirmation  |
    | Test       |  User     | email         | Welcome     |  Welcome        |
    | Test       |  User     | email@        | Welcome@123 |  Welcome@12     |
    | Test       |  User     | email@mail    | aaaa@123    |  Welcome        |
    | Test       |  User     | email@mail.   | Abcdefg1    |  Welcome        |
    | Test       |  User     | email@mail.c  | Abcdefg1    |  Welcome        |

  @RegisterSuccessfulScenario
  Scenario: Successful registration
    Given I am on home page
    When I open the register page
    And I fill up the registration form
    And I click the register button
    Then I should be registered successfully