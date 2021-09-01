@NAVF-306
Feature: Vehicle General Information Page
  Background:
    Given the user is on the login page
  @NAVF-348
  Scenario:Users should see General Information Page
    Given the user enters the store manager information
    And the user navigates to "Fleet" "Vehicles"
    When user click on any row from the page
    Then users should be on General Information Page Vehicle
  @NAVF-349
  Scenario: Sales manager and store manager should see "Edit", "Delete" and "Add Event"
  buttons on the "General Information" page
    Given the user enters the sales manager information
    And the user navigates to "Fleet" "Vehicles"
    When user click on any row from the page
    Then users should see the buttons Edit, Delete and Add Event on General Information Page Vehicle
  @NAVF-350
  Scenario:Driver should see only "Add Event" button
    Given the user enters the driver information
    And the user navigates to "Fleet" "Vehicles"
    When user click on any row from the page
    Then driver should see Add Event button and Edit, Delete buttons not displayed on General Information Page



