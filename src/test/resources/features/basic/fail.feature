Feature: Sample failing feature

  @Sample
    @Z
  Scenario Outline: Sample failing Scenario
    Given Open site with <browser>
    And This step will fail
    Examples:
      | browser |
      | chrome   |
      | firefox  |
      | edge  |