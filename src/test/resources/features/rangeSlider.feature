Feature: Range slider

  @Sample
  @RangeSlider
  Scenario: Move the range slider's handle to a required value
    Given Open site
    When Click to 'Progress_Bars' menu item
    And Click to 'Drag_&_Drop_Sliders' submenu item
    Then The 'Range_Sliders' page opens
    When I set the value of the 'Top_Left_Slider' to '7' on the range slider page
    Then The value displayed on the 'Top_Left_Slider_Output' is '7' on the range slider page

