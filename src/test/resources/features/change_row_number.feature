@wip
Feature: Changing the row number feature


  Scenario: Change row number on profile page
    Given user is logged in
    When use change row number as 20
    Then new row number should be 20


