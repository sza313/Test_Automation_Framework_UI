Feature: Range slider

  @Sample
  @RangeSlider
  Scenario Outline: Move the range slider's handle to a required value
    Given Open site
    When Click to 'Progress_Bars' menu item
    And Click to 'Drag_&_Drop_Sliders' submenu item
    Then The range sliders page opens
    When I set the value of the 'Top_Left_Slider' to '<value>' on the range slider page
    Then The value displayed on the 'Top_Left_Slider_Output' is '<value>' on the range slider page
    Examples:
      | value |
      | 4     |

