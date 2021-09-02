Feature: Filter Vehicle Table Data General

  Background:
    Given the user is on the login page
    And the user enters the store manager information
    And the user navigates to "Fleet" "Vehicles"
    And the user clicks on filter icon

  @NAVF-320
  Scenario: User can see Manage Filters module after clicking filter icon
    Then Manage Filters module should be displayed

  @NAVF-322
  Scenario Outline: User can apply filters by clicking on filter name from Manage Filters menu
    When the user clicks on Manage Filters module
    And the user selects "<option>" from Manage Filters menu
    Then "<selectedFilter>" box should be displayed next to the Manage Filters module

    Examples:
      | option                    | selectedFilter            |
      | License Plate             | License Plate             |
      | Tags                      | Tags                      |
      | Driver                    | Driver                    |
      | Location                  | Location                  |
      | Chassis Number            | Chassis Number            |
      | Model Year                | Model Year                |
      | Last Odometer             | Last Odometer             |
      | Immatriculation Date      | Immatriculation Date      |
      | First Contract Date       | First Contract Date       |
      | Catalog Value (VAT Incl.) | Catalog Value (VAT Incl.) |
      | Seats Number              | Seats Number              |
      | Doors Number              | Doors Number              |
      | Color                     | Color                     |
      | Transmission              | Transmission              |
      | Fuel Type                 | Fuel Type                 |
      | CO2 Emissions             | CO2 Emissions             |
      | Horsepower                | Horsepower                |
      | Horsepower Taxation       | Horsepower Taxation       |
      | Power (kW)                | Power (kW)                |

  @NAVF-323
  Scenario: User can find a filter by typing the filter name from Manage Filters menu
    When the user clicks on Manage Filters module
    And the user types "Location" to the input box
    Then Only the options which include "Location" should be displayed under Manage Filters

  @NAVF-324
  Scenario: User can apply multiple filters at the same time
    When the user clicks on Manage Filters module
    And the user selects "Driver" from Manage Filters menu
    And the user selects "Color" from Manage Filters menu
    Then "Driver" box should be displayed next to the Manage Filters module
    And "Color" box should be displayed next to the Manage Filters module

  @NAVF-325
  Scenario: User can remove all filters by clicking on the reset icon
    When the user clicks on Manage Filters module
    And the user selects "Driver" from Manage Filters menu
    And the user selects "Color" from Manage Filters menu
    And the user clicks on reset icon
    Then "Driver" box should not be displayed next to the Manage Filters module
    And "Color" box should not be displayed next to the Manage Filters module