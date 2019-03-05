Feature: Sample feature

  @Sample
  Scenario: Sample Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item

  @Sample
  @ClickWithJS
  Scenario: Click with javascript
    Given Open site
    When Click with javascript to 'Input_Forms' menu item
    And Click with javascript to 'Simple_Form_Demo' submenu item
    Then The simple form page opens
