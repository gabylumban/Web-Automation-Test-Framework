Feature: User API

  Scenario: Get users with valid page
    Given I set page to 1
    When I request GET /users
    Then I receive status code 200
    And response contains users list

  Scenario: Get user by invalid ID
    Given I set user id to 999
    When I request GET /users/{id}
    Then I receive status code 404

  Scenario: Get users with invalid page
    Given I set page to -1
    When I request GET /users
    Then I receive status code 200

  Scenario: Get users with boundary page 0
    Given I set page to 0
    When I request GET /users
    Then I receive status code 200
    And response page is 1

