Feature: Grid Settings

  Background: 
    Given the user is on the login page
    And the user enters the store manager information
    And the user navigates to "Fleet" "Vehicles"

  @wip
    Scenario: Column names in grid settings should be complete
      When the user clicks to grid settings button
      Then Column names in grid settings should include following options
    |Id                       |
    |License Plate            |
    |Tags                     |
    |Driver                   |
    |Location                 |
    |Chassis Number           |
    |Model Year               |
    |Last Odometer            |
    |Immatriculation Date     |
    |First Contract Date      |
    |Catalog Value (VAT Incl.)|
    |Seats Number             |
    |Doors Number             |
    |Color                    |
    |Transmission             |
    |Fuel Type                |
    |CO2 Emissions            |
    |Horsepower               |
    |Horsepower Taxation      |
    |Power (KW)               |

  @wip
    Scenario: User can find any column name by using 'Quick Search' functionality
      When the user clicks to grid settings button
      And the user clicks and type any "Id"
      Then column name should be found
  @wip
    Scenario: User can select the columns to be displayed by clicking the column name
      When the user clicks to grid settings button
      And the user unselect all column checkbox
      Then Id should be displayed on table
  @wip
    Scenario: User can arrange the order of the columns
      When the user clicks to grid settings button
      And user change the order of columns by dragging
      Then order should be changed
  @wip
    Scenario: User can see all corresponding changes
      Then All cars table should be updated

