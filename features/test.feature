Feature: test cucumber implementation

  Scenario: test one
    Given User starts test
    When User Enters values "test1" and "test2"
    Then User stops

    Scenario Outline:

      Examples:
        |  |