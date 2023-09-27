Feature: Search book feature on Book Store Page


  Scenario: Search books by any text (in title,author,publisher)
    Given user is logged in
    Given user is on the Book Store page
    When user enters "java" into search box
    Then listed book infos should contain "java"




