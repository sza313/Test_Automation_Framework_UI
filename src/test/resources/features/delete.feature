Feature: Delete text from field feature

  @Sample
  Scenario: Delete text from field with backspace button
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message_form'
    And Delete text from 'Message_form' with backspace button
    And Click 'Show_message' button
    Then 'Displayed message' section is empty

  @Sample
  Scenario: Clear text from field
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message_form'
    And Clear data from 'Message_form' textbox
    And Click 'Show_message' button
    Then 'Displayed message' section is empty
