Feature: Delete text from textbox

  @Sample
  @DeleteOnSampleForm
  Scenario: Delete text from field with backspace button
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message'
    And Delete text from 'Message' with backspace button
    And I click on the 'Show_Message' button on the simple form page
    Then 'Displayed message' section is empty

  @Sample
  @DeleteOnSampleForm
  Scenario: Clear text from field
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message'
    And Clear data from 'Message' textbox
    And I click on the 'Show_Message' button on the simple form page
    Then 'Displayed message' section is empty
