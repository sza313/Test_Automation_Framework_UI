Feature: Sample feature

  Scenario: Open custom site 1
    Given Open site in 'chrome' with url 'https://www.google.com'
    When I search for 'hammer'
    Then search result page is displayed

  Scenario: Open custom site 2
    Given Open site in 'chrome' with url 'https://www.google.com'
    When I search for 'screwdriver'
    Then search result page is displayed

  Scenario: Open custom site 3
    Given Open site in 'chrome' with url 'https://www.google.com'
    When I search for 'fail the assertion'
    Then search result page is NOT displayed