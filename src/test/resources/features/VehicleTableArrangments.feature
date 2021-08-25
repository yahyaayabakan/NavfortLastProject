Feature: Vehicle Table Arrangments

  Background: Login as a driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login
    Given the user navigates to "Fleet" "Vehicles"


  @Tedros
  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
    When user clicks on view per page drop down
    Then rows or vehicle numbers should be displayed
  @Tedros
  Scenario: The value of 'View Per Page' should be '25' by default
    When user clicks the reset button
    Then rows or vehicle numbers displayed should be "25"

  @Tedros
  Scenario: user should be able to select and display the rows/vehicle numbers by selecting each of the following 10,25,50 and 100 from the drop down list
    When user selects "10" from the dropdown list
    Then user should be able to display 10 rows or vehicle numbers if the rows number is equal to or greater than 25
    When user selects "25" from the dropdown list
    Then user should be able to display 10 rows or vehicle numbers if the rows number is equal to or greater than 25
    When user selects "50" from the dropdown list
    Then user should be able to display 50 rows or vehicle numbers if the rows number is equal to or greater than 25
    When user selects "100" from the dropdown list
    Then user should be able to display 100 rows or vehicle numbers if the rows number is equal to or greater than 25
  @Tedros
  Scenario: User can sort a column in ascending or descending order by clicking the column name
    When user should click any column name
    Then the column should be sorted in ascending or descending order

  @Tedros
  Scenario: User can reset the table by using the reset button
    When user clicks the reset button
    Then rows or vehicle numbers displayed should be "25"