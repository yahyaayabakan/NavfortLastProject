@completed
Feature: Vehicle Table View

  Background:
    Given  the user is on the login page


  @NAVF-352
  Scenario Outline: All user types can see all vehicle information under 'Fleet-Vehicles' module
    Given the user logged in as "<userType>"
    Then the user navigates to "Fleet" "Vehicles"
    And user can see all vehicle info

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |

  @NAVF-354
  Scenario:User can see total page number
    When the user logs in using "user1" and "UserUser123"
    Then the user navigates to "Fleet" "Vehicles"
    And user should see total page number

  @NAVF-355
  Scenario: User can go to next page clicking > button and < to go back
    Given the user logs in using "user1" and "UserUser123"
    When the user navigates to "Fleet" "Vehicles"
    Then user clicks > button to go to next page
    And the user clicks < button to go to previous page


  @NAVF-356
  Scenario: User can see total recordings of vehicles
    Given the user logs in using "user1" and "UserUser123"
    When the user navigates to "Fleet" "Vehicles"
    Then the user should see total recordings of vehicles

  @NAVF-357
  Scenario: User can download table data in XLS or CSV format from "Export Grid"
    Given the user logs in using "user1" and "UserUser123"
    When the user navigates to "Fleet" "Vehicles"
    Then user can download table data in XLS or CSV format from Export Grid



