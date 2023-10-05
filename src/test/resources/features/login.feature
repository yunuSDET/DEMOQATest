
@login @smoke
Feature: Book Store Login Feature



    Scenario: Login scenario
      Given user is on the login page
      When user enters correct userName
      And user enters correct password
      And user click login button
      Then user should see userName on the profile page



  Scenario: Login scenario with enter
    Given user is on the login page
    When user enters correct userName
    And user enters correct password
    And user hits the enter
    Then user should see userName on the profile page





  Scenario: Negative Login scenario with no credentials
    Given user is on the login page
    When user enters "" as userName
    And user enters "" as password
    And user click login button
    Then input boxes should be red lined








  Scenario: Negative Login scenario with wrong userName,correct password
    Given user is on the login page
    When user enters "wrongUserName" as userName
    And user enters correct password
    And user click login button
    Then Invalid username or password error should occur





  Scenario: Negative Login scenario with correct userName,wrong password
    Given user is on the login page
    When user enters correct userName
    And user enters "wrongPassword" as password
    And user click login button
    Then Invalid username or password error should occur






  Scenario: Negative Login scenario with wrong userName and password
    Given user is on the login page
    When user enters "wrongUserName" as userName
    And user enters "wrongPassword" as password
    And user click login button
    Then Invalid username or password error should occur