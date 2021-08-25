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
