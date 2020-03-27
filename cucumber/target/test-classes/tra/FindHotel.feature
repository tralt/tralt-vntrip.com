Feature: Visitor finds a hotel for his trip

  Scenario: Visitor would like find a good hotel for his trip
    Given He finds hotel on the vntrip website
    When He attempts to search with a destination, check in date and check out date
    Then He sees that the list of hotel will be shown