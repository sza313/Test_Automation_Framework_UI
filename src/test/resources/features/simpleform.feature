Feature: Writing To Textbox

  @Sample
  @SimpleForm
  Scenario: Writing string into message textbox on the simple forms page
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    Then The 'Simple_Form' page opens
    When I write a 'String' to the 'Message' textbox on the simple form page
    And I click on the 'Show_Message' button on the simple form page
    Then The same 'String' shows up at the 'User_Message_Display' section on the simple form page
