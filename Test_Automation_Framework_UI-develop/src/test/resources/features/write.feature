Feature: Write feature

  @Sample
  Scenario: Write random alphabetic string Scenario
    Given Open SimpleForm Page
    When Write random alphabetic string into the textbox
    And Click Show Message button
    Then Message is displayed in Your Message field


  @Sample
  Scenario: Write random numeric string Scenario
    Given Open SimpleForm Page
    When Write random numeric string into the textbox
    And Click Show Message button
    Then Message is displayed in Your Message field

  @Sample
  Scenario: Write random alphanumeric string Scenario
    Given Open SimpleForm Page
    When Write random alphanumeric string into the textbox
    And Click Show Message button
    Then Message is displayed in Your Message field

  @Sample
  Scenario: Clear textbox with backspace Scenario
    Given Open SimpleForm Page
    Given Write random alphabetic string into the textbox
    When Using method to remove the text with backspace
    Then Text is removed from the textbox
