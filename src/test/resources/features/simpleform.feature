Feature: Writing To Textbox

  @Sample
  @SimpleForm
  Scenario Outline: Writing string into message textbox on the simple forms page
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    Then The simple form page opens
    When I write a '<string>' to the 'Message' textbox on the simple form page
    And I click on the 'Show_Message' button on the simple form page
    Then The same '<string>' shows up at the user message display section on the simple form page
    Examples:
      | string         |
      | example string |