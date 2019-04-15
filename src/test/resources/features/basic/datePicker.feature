Feature: Date pickers

  @Sample
  @DatePicker
  Scenario: Select date from dropdown
    Given Open site
    When Click to 'Date_Pickers' menu item
    And Click to 'Bootstrap_Date_Picker' submenu item
    Then The bootstrap date picker page opens
    When I click on the 'Start_Date' input field in the date range example section
    And I select the date '3 Apr 2037' from dropdown
    Then '03/04/2037' appears in the start date input field