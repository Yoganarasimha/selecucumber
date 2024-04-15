Feature: Selenium run test

  Scenario Outline:
    Given User Opens Browser
    When User enters "<string>"
    Then User sees result
    Examples:
      | string |
      |cucumber|
      |selenium|
      |ventura |

  Scenario: Check Screenshot
    Given User Opens Browser
    When User enters "howdy"
    Then User saw result