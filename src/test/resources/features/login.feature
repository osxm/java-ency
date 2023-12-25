Feature: Test login feature of lemfix
  I want to use this case to test login functionality

  @tag1
  Scenario Outline: Test login feature of mysite
    Given I navigated to mysite
    When I input "<username>" and "<password>" to login
    Then I verify login "<result>"

    Examples: 
      | username        | password  | result  |
      | admin           | xxx      | success |