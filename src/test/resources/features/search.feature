@search
Feature: Search book feature on Book Store Page


  Scenario Outline: Search books by any text (in title,author,publisher)
    Given user is logged in
    Given user is on the Book Store page
    When user enters "<keyword>" into search box
    Then listed book infos should contain "<keyword>"

    Examples:
      | keyword     |
      | java        |
      | learn       |
      | speak       |
      | Kyle        |
      | programming |
      | no          |
      | add         |
      | script      |




