Feature: PhpTravelBooking

  @Travel
  Scenario Outline: Book a travel on PhpTravelsPage
    #Login
    Given Open site
    When Click to 'MY ACCOUNT' menu item on PhpTravels
    And Click to 'Login' submenu item on PhpTravels
    When Login to the PhpTravels page
    And Wait for My Account page is loaded

    #Hotel search
    Then Click to 'HOTELS' menu item on MyAccount page
    And Wait for HOTELS page is loaded
    Then Click to 'Search by' menu item on Hotels page
    Then Write 'Dubai' to the 'searchBy' box
    And Click the 'first' search result
    Then Click to 'Check in' menu item on Hotels page
    And Click 'next month Friday' in the calendar
    And Click 'one week later' in the calendar
    Then Click to 'Adult child' menu item on Hotels page
    And Increase child numbers by 2
    Then Click to 'SEARCH' menu item on Hotels page
    And Wait for SEARCH page is loaded
    Then I set the value of the 'STAR GRADE' section's '4 star' checkbox to 'true' on the Search Result page
    And I change the value of the 'Left Slider' with '<lower>' on the Search Result page
    And I change the value of the 'Right Slider' with '<higher>' on the Search Result page
    And I set the value of the 'PROPERTY TYPES' section's 'Hotel' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'Airport Transport' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'Restaurant' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'WI-FI Internet' checkbox to 'true' on the Search Result page
    And Click to 'SEARCH' item
    Then Wait for SEARCH page is loaded
    And Click to 'Testing2 Hotel' item
    Then Wait for Testing2 Hotel page is loaded

    #Hotel booking
    Then I set the value of the 'STANDARD ROOM' checkbox to 'true' on the Testing2 Hotel page
    And Click to 'BOOK NOW' button
    And Wait for Confirmation page is loaded
    Then Click to 'CONFIRM THIS BOOKING' button on Confirmation page
    And Wait for Preliminary page is loaded
    And Wait until 'Invoice' element is visible
    And Wait for Invoice page is loaded

    Examples:
    | lower  | higher |
    |  40    |  -40   |

