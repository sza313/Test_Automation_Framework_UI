Feature: Telekom

  @Sample
  @Telekom
  Scenario Outline: Set the single checkbox value to true on the checkbox page
    Given Open site
    When User clicks to the 'Computers' menu item
    And User clicks to the 'Desktops' submenu item
    Then User is on the Desktops page
    When User clicks to '<productName>' product
    And User clicks to Add to cart button
    Then Item added to the cart successfully
    When User clicks to the 'Cart' menu item
    Then User wait '2' seconds

    Examples:
      | productName                   |
      | Build your own cheap computer |
      | Build your own computer       |
