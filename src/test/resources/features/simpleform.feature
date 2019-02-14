Feature: Writing To Textbox

  @Sample
  Scenario: Writing string into message textbox on the simple forms page
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And I write a 'String' to the 'Message' textbox on the simple form page
