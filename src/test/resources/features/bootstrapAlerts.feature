Feature: Bootstrap Alerts

  @Sample
  @BootstrapAlerts
  Scenario Outline: Validating that the autoclosable alerts close after the given time
    Given Open site
    When Click to 'Alerts_&_Modals' menu item
    And Click to 'Bootstrap_Alerts' submenu item
    Then The bootstrap alerts page opens
    When Click on '<autoclosable_alert>' button
    Then Then the '<autoclosable_alert>' message disappears after '<time>' seconds
    Examples:
      | autoclosable_alert         | time |
      | autoclosable_success_alert | 5    |
      | autoclosable_danger_alert  | 5    |
      | autoclosable_warning_alert | 3    |
      | autoclosable_info_alert    | 6    |
