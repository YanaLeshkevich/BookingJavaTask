Feature: Search Airport taxis
  This feature deals with search some variants of taxis

  Background: Set up the browser
    Given User is on home page
    And User change the language

  Scenario: Check number of passengers on the taxi form
    When User choose Airport taxi
    And Write Pick-up and Drop-off locations
    And Click Search button for taxi
    Then Verify the number of passengers on the taxi form