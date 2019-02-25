Feature: Drag and drop a webelement

  @Sample
    @DragAndDrop
  Scenario: Drag and drop a webelement to another webelement
    Given Open site
    When Click to 'Others' menu item
    And Click to 'Drag_And_Drop' submenu item
    And Drag 'Draggable_item' element into droppable
    And Waiting for 'Dropped_item' is visible after 50 seconds under the Dropped Item List
