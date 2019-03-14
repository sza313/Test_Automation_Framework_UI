Feature: Write text to field feature

  @Sample
  @SimpleFormRandom
  Scenario: Write random alphabetic string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphabetic characters in textbox 'Message'
    And I click on the 'Show_Message' button on the simple form page
    Then The same string is shown in the displayed message

  @Sample
  @SimpleFormRandom
  Scenario: Write random numeric string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random numeric characters in textbox 'Message'
    And I click on the 'Show_Message' button on the simple form page
    Then The same string is shown in the displayed message

  @Sample
  @SimpleFormRandom
  Scenario: Write random alphanumeric string Scenario
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 20 random alphanumeric characters in textbox 'Message'
    And I click on the 'Show_Message' button on the simple form page
    Then The same string is shown in the displayed message

  @Sample
  @AdditionOfTwoNumbers
  Scenario: Check if addition of two numbers gives the correct result
    Given Open site
    When Click to 'Input_Forms' menu item
    And Click to 'Simple_Form_Demo' submenu item
    And Write 3 random numeric characters in textbox 'Number1'
    And Write 3 random numeric characters in textbox 'Number2'
    And I click on the 'Get_Total' button on the simple form page
    Then The correct sum is displayed
