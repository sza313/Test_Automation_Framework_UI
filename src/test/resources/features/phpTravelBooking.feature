Feature: PhpTravelBooking

  @Travel
  Scenario Outline: Book a travel on PhpTravelsPage
    #Login
    Given Open site
    When Click to 'MY ACCOUNT' menu item on PhpTravels
    And Click to 'Login' submenu item on PhpTravels
    When Login to the PhpTravels page
    And Wait for My Account page is loaded

    #Hotel booking
    Then Click to 'HOTELS' menu item on MyAccount page
    And Wait for HOTELS page is loaded
    Then Click to 'Search by' menu item on Hotels page
    Then Write 'New York' to the 'searchBy' box
    And Click the 'first' search result
    Then Click to 'Check in' menu item on Hotels page
    And Click 'next Friday' in the calendar
    And Click 'one week later' in the calendar
    Then Click to 'Adult child' menu item on Hotels page
    And Increase child numbers by 2
    Then Click to 'SEARCH' menu item on Hotels page
    And Wait for SEARCH page is loaded
    Then I set the value of the 'STAR GRADE' section's '4 star' checkbox to 'true' on the Search Result page
   # And I set the value of the 'Left Slider' to '70' on the Search Result page
   # And I set the value of the 'Right Slider' to '200' on the Search Result page
    And I set the value of the 'PROPERTY TYPES' section's 'Hotel' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'Airport Transport' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'Restaurant' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's 'WI-FI Internet' checkbox to 'true' on the Search Result page
    And Click to 'SEARCH' item
    Then Wait for SEARCH page is loaded

    Examples:
    | lower  | higher |
    |  70    |  200   |

