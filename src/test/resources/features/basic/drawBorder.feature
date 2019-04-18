Feature: Draw border around element

  @DrawBorder
  @Sample
  Scenario: Draw border around element
    Given Open site
    Then Draw border around 'Site_Name'


  @DrawBorder
  @Sample
  Scenario: Draw border around clicked element
    Given Open site
    When Click with visualization to 'Input_Forms' menu item
    Then A red border around 'Input_Forms' menu item appears
    And 'Simple_Form_Demo' submenu item becomes visible
