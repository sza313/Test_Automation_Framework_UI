Feature: Telekom

  @Telekom
  Scenario Outline: Add desktop products to the cart
    Given Open site
    When User clicks to the 'Computers' menu item
    And User clicks to the 'Desktops' submenu item
    Then User is on the 'Desktops' page
    When User clicks to '<productName>' product
    And User clicks to Add to cart button
    Then '1' Item added to the cart successfully
    When User clicks to the 'Cart' menu item
    Then User wait '2' seconds

    Examples:
      | productName                   |
      | Build your own cheap computer |
      | Build your own computer       |

  @Telekom
  Scenario Outline: Add parametrized items to the cart
    Given Open site
    When User clicks to the '<menu>' menu item
    And User clicks to the '<subMenu>' submenu item
    Then User is on the '<title>' page
    When User clicks to '<productName>' product
    And User clicks to Add to cart button
    Then '1' Item added to the cart successfully
    When User clicks to the 'Cart' menu item
    Then User wait '2' seconds

    Examples:
      | menu        | subMenu     | title       | productName                   |
      | Computers   | Desktops    | Desktops    | Build your own cheap computer |
      | Computers   | Desktops    | Desktops    | Build your own computer       |
      | Jewelry     |             | Jewelry     | Black and White Diamond Heart |
      | Jewelry     |             | Jewelry     | Create Your Own Jewelry       |
      | Electronics | Cell phones | Cell phones | Smartphone                    |

  @Telekom
  Scenario: Add more items to the cart
    Given Open site
    When User clicks to the 'Computers' menu item
    And User clicks to the 'Desktops' submenu item
    Then User is on the 'Desktops' page
    When User clicks to 'Build your own cheap computer' product
    And User clicks to Add to cart button
    Then '1' Item added to the cart successfully
    When User clicks to the 'Electronics' menu item
    And User clicks to the 'Cell phones' submenu item
    Then User is on the 'Cell phones' page
    When User clicks to 'Smartphone' product
    And User clicks to Add to cart button
    Then '2' Item added to the cart successfully
    When User clicks to the 'Cart' menu item
    Then User wait '2' seconds

