@NAVF-367
Feature: Add Event in General Information

  Background:
    Given the user is on the login page

  @NAVF-362 @NAVF-361
  Scenario Outline: <userType> can access the Add Event page
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John" from the list
    Then user should be able to access "Add Event" module

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |

  @NAVF-363 @NAVF-361
  Scenario: Driver can NOT add an event
    When the user enters the driver information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John" from the list
    Then the user should NOT be able to see <Add Event> module

  @NAVF-364 @NAVF-361
  Scenario Outline: Verify compulsory fields in <Add Event>
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John" from the list
    When user should be able to access "Add Event" module
    Then user should see the next fallowing fields

      | Title*           |
      | Owner*           |
      | Organizer email* |
      | Start*           |
      | End*             |

    Examples:
      | userType      |
      | sales_manager |
      | store_manager |

  @NAVF-365 @NAVF-361
  Scenario Outline: <userType> cannot add event with blank compulsory fields
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John" from the list
    When user should be able to access "Add Event" module
    And user leave one ore more compulsory fields blank "<Title>", "<Organizer display name>", "<Organizer email>"
    Then user should see warning messages

    Examples:
      | userType      | Title | Organizer display name | Organizer email |
      | sales_manager |       | aefae                  | \sfbzdfb        |
      | sales_manager | Mr.   |                        | abc             |
      | store_manager |       |                        |                 |
      | store_manager | Mr.   |                        | abc             |

  @NAVF-366 @NAVF-361
  Scenario Outline: Verify if <userType> can add an description
    When the user enters the "<userType>" information
    Then the user navigates to "Fleet" "Vehicles"
    And the user click on "John" from the list
    And user should be able to access "Add Event" module
    When user fill all the compulsory fields "<Title>", "<Organizer display name>", "<Organizer email>"
    Then user should be able to add description in description box
    And user should see "Calendar event saved"

    Examples:
      | userType      |Title | Organizer display name | Organizer email |
      | sales_manager |Mr    |Arnold                  |arnold@gmail.com |
      | store_manager |Mr    |Arnold                  |arnold@gmail.com |






