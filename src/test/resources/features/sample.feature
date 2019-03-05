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
    When Click with javascript to 'Input_Forms' element
    And Click with javascript to 'Simple_Form_Demo' element
    Then The simple form page opens

  @Sample
  @Scroll
  Scenario: Scroll to a webelement
    Given Open site
    When Scroll to the 'Tutorials_Menu' webelement on main page

    @Sample
    @ScrollWithOffset
      Scenario: Scroll to webelement with offset
      Given Open site
      When Scroll to the 'Tutorials_Menu' webelement with '0' px offset along the x axis and '-150' px offset along the y axis
