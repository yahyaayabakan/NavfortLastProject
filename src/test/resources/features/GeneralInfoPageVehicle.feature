@wip
Feature: Vehicle General Information Page
  Background:
    Given the user is on the login page
    And the user enters the store manager information
    And the user navigates to "Fleet" "Vehicles"

  Scenario:Users should see General Information Page
    When user click on any row from the page
    Then users should be on General Information Page Vehicle

  Scenario: Sales manager and store manager should see "Edit", "Delete" and "Add Event"
  buttons on the "General Information" page
    When user click on any row from the page
    Then users should see the buttons Edit, Delete and Add Event on General Information Page Vehicle

  Scenario:Driver should see only "Add Event" button
    When user click on any row from the page
    Then driver should see Add Event button and Edit, Delete buttons not displayed on General Information Page



