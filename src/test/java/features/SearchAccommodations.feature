Feature: Search Accommodations
  This feature deals with search some variants of accommodations

  Background: Find a hotel with free rooms in Florence
    Given User is on home page
    When User change the language
    And User choose country
    And Choose the dates for travel
    And Click Search button
    Then Verify that user on the country page

  Scenario: Come to the page of a hotel and there're should be available rooms
    When User sort by free cancellation
    And Click on the first hotel
    Then Verify there are free rooms

  Scenario: Compare title with number of hotels with actually numbers of hotels
    When User sort by price option one
    And Sort by Front Desk
    And Sort by availability hotel
    Then Verify number of hotels with actually numbers of hotels

  Scenario: Check items order by price
    When Sort result by lower price
    Then Verify items order by price

  Scenario: Check items order by Distance from Downtown
    When Sort result by Distance from Downtown
    Then Verify items order by Distance from Downtown

  Scenario: Check items order by stars
    When Sort result by stars
    Then Verify items order stars

  Scenario: Change number of adults in the Search form and check the hotel form
    When Change number of adults
    And Click Search button
    And Click on the first hotel
    Then Verify number of adults on the hotel page