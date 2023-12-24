Feature: User
  Scenario: create
    Given User 100 not exist
    When create User 100
    Then can query User 100