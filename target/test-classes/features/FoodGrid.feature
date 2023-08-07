Feature: Food Grid Testing

  @Test
  Scenario: Get Row by ID
    Given I opened the url: https://demo.aspnetawesome.com/
    And I checked that the Food Grid Table is present
    When I search for a row entry using the ID: 1639
    Then I will get the row data for that entry