Feature: Add Event in General Information


  Scenario Outline: <userType> can access the Add Event page
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John Johnson" from the list
    Then user should be able to access "Add Event" module

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |


  Scenario: Driver can NOT add an event
    Given the user is on the login page
    When the user enters the driver information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John Johnson" from the list
    Then the user should not be able to see <Add Event> module

  @wip1
  Scenario Outline: Compulsory fields in <Add Event>
    Given the user is on the login page
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John Johnson" from the list
    When user should be able to access "Add Event" module
    Then user should see the next fallowing fields

      | Title           |
      | Owner           |
      | Organizer email |
      | Start           |
      | End             |

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |


  Scenario: Verify if all


