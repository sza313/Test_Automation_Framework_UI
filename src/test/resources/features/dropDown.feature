Feature: Choose from dropdown list

  @Sample
  @Dropdown
  Scenario Outline: Write into a field and choose the first autosuggestive option
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'JQuery_dropdown' submenu item
    And Click to 'Select_country' dropdown field
    And Write a '<country>' into 'Search_country' field
    And Click on 'Result'
    Then The correct '<country>' is selected in the list
    Examples:
      | country                  |
      | Australia                |
      | Bangladesh               |
      | Denmark                  |
      | Hong Kong                |
      | India                    |
      | Japan                    |
      | Netherlands              |
      | New Zealand              |
      | South Africa             |
      | United States of America |
      | pizza                    |
