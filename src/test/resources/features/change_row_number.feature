@changeRowNumber  @smoke
Feature: Changing the row number feature



  Scenario Outline: Change row number on profile page
    Given user is logged in
    When use change row number as "<value>"
    Then new row number should be "<value>"

    Examples:
      | value |
      | 5     |
      | 10    |
      | 20    |
      | 25    |
      | 50    |
      | 100   |



