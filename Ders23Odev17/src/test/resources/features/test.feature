Feature: DemoQA Test Scenarios

  Scenario: Click the "Click Me" button
    Given I am on the elements page
    When I click the "Buttons" option
    And I click the "Click Me" button
    Then I read the message

  Scenario: Add and edit a record
    Given I am on the webtables page
    When I click the "ADD" button
    And I fill in the form with valid data
    And I submit the form
    Then the record should be added successfully