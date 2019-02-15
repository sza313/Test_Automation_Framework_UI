Feature: Write text to field feature

  @Sample
  Scenario: Write random alphabetic string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message_form'
    And Click 'Show_message' button
    Then Message is displayed in 'Your_message' field

  @Sample
  Scenario: Write random numeric string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random numeric characters in textbox 'Message_form'
    And Click 'Show_message' button
    Then Message is displayed in 'Your_message' field

  @Sample
  Scenario: Write random alphanumeric string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphanumeric characters in textbox 'Message_form'
    And Click 'Show_message' button
    Then Message is displayed in 'Your_message' field

