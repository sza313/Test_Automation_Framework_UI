Feature: Checkbox

  @Sample
  @Checkbox
  Scenario: Set the single checkbox value to true on the checkbox page
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Checkbox_Demo' submenu item
    Then The checkbox page opens
    When I set the value of the 'Single_Checkbox_Demo' checkbox to 'true' on the checkbox page
    Then The message 'Success - Check box is checked' shows up on the checkbox page