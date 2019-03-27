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
    Then Write '<city>' to the 'searchBy' box
    And Click the 'first' search result
    Then Click to 'Check in' menu item on Hotels page
    And Click '<day from>' in the calendar
    And Click '<day until>' in the calendar
    Then Click to 'Adult child' menu item on Hotels page
    And Decrease adult numbers by <times1>
    And Increase child numbers by <times2>
    Then Click to 'SEARCH' menu item on Hotels page
    And Wait for SEARCH page is loaded
    Then I set the value of the 'STAR GRADE' section's '<hotel rate>' checkbox to 'true' on the Search Result page
    And I change the value of the 'Left Slider' with '<lower>' on the Search Result page
    And I change the value of the 'Right Slider' with '<higher>' on the Search Result page
    And I set the value of the 'PROPERTY TYPES' section's '<property1>' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's '<amenity1>' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's '<amenity2>' checkbox to 'true' on the Search Result page
    And I set the value of the 'AMENITIES' section's '<amenity3>' checkbox to 'true' on the Search Result page
    And Click to 'SEARCH' item
    Then Wait for SEARCH page is loaded
    And Click to '<test hotel>' item
    Then Wait for Testing Hotel page is loaded

    #Hotel booking
    Then I set the value of the 'STANDARD ROOM' checkbox to 'true' on the Testing2 Hotel page
    And Click to 'BOOK NOW' button
    And Wait for Confirmation page is loaded
    Then Click to 'CONFIRM THIS BOOKING' button on Confirmation page
    And Wait for Preliminary page is loaded
    And Wait until 'Invoice' element is visible
    And Wait for Invoice page is loaded

    Examples:
   |city    | day from           | day until      | times1| times2 |hotel rate | lower | higher | property1   | amenity1          | amenity2        |amenity3      | test hotel     |
   |Dubai   | next month Friday  | one week later | 0     |    2   |  4 star   |40     |  -40   | Hotel       | Airport Transport | Restaurant      |WI-FI Internet| Testing1 Hotel |
   |London  | next month Saturday| one day later  | 0     |    0   |  5 star   |20     |  -30   | Apartment   | Business Center   | Laundry Service |Swimming Pool | Testing1 Hotel |
   |New York| next month Friday  | one day later  | 1     |    3   |  3 star   |50     |  -60   | Villa       | Restaurant        | Inside Parking  |Fitness Center| Testing1 Hotel |