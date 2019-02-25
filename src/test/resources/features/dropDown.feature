Feature: Use dropdown lists

  @Sample
  Scenario Outline: Write into a field and choose the first autosuggestive option
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'JQuery_dropdown' submenu item
    And I start to type '<string>' to the Select country 'Dropdown' field and hit enter
    Then Appropriate '<country>' is selected in the 'dropdown' field
    Examples:
      | string |  country |
      | jap    |  Japan   |
      | den    |  Denmark |
