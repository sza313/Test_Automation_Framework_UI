Feature: PhpTravelBooking

  @Travel
  Scenario: Book a travel on PhpTravelsPage
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
    Then Click to 'Check in' menu item on Hotels page
    And Click 'next Friday' for check in time
    Then Click to 'Check out' menu item on Hotels page
    And Click 'one week later' for check out time
    Then Click to 'Adult child' menu item on Hotels page
    And Increase child numbers by 2
    Then Click to 'SEARCH' menu item
    And Wait for SEARCH page is loaded
