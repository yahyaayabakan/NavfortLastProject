
Feature: Vehicle Table Arrangments

  Background: Login as a driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login
    Given the user navigates to "Fleet" "Vehicles"


  @Tedros  @NAVF-329
  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
    When user clicks on view per page drop down
    Then rows or vehicle numbers should be displayed

  @Tedros  @NAVF-330
  Scenario Outline: The value of 'View Per Page' should be '25' by default
    Given user clicks on view per page drop down
    And user selects "<dropDown>" from the dropdown list
    When user clicks the reset button
    Then rows or vehicle numbers displayed should be "25"
    Examples:
    |dropDown|
    |10|
    |25|
    |50|
    |100|

  @Tedros  @NAVF-331
  Scenario: user should be able to select and display the rows/vehicle numbers by selecting each of the following 10,25,50 and 100 from the drop down list
    Given user clicks on view per page drop down
    When user selects "10" from the dropdown list
    Then user should be able to display 10 rows or vehicle numbers if the number of vehicles registered is equal to or greater than 10
    Given user clicks on view per page drop down
    When user selects "25" from the dropdown list
    Then user should be able to display 25 rows or vehicle numbers if the number of vehicles registered is equal to or greater than 25
    Given user clicks on view per page drop down
    When user selects "50" from the dropdown list
    Then user should be able to display 50 rows or vehicle numbers if the number of vehicles registered is equal to or greater than 50
    Given user clicks on view per page drop down
    When user selects "100" from the dropdown list
    Then user should be able to display 100 rows or vehicle numbers if the number of vehicles registered is equal to or greater than 100
  @Tedros  @NAVF-332
  Scenario Outline: User "driver"  can sort a column "<name>" in ascending or descending order by clicking the column name
    When user should click any column "<name>"
    Then As "driver" the column "<name>" should be sorted in ascending or descending order in default view per page condition
    Examples:
    |name|
    |License Plate|
    |Driver|
    |Location|
    |Chassis Number|
    |Model Year|
    |Last Odometer|
    |Immatriculation Date|
    |First Contract Date|
    |CVVI|
    |Seats Number|
    |Doors Number|
    |Color|
    |Transmission|
    |Fuel Type|
    |CO2 Emissions|
    |Horsepower|
    |Horsepower Taxation|
    |Power (kW)|



  @Tedros  @NAVF-333
  Scenario: User can reset the table by using the reset button
    When user clicks the reset button
   Then rows or vehicle numbers displayed should be "25"