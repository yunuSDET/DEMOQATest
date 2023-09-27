
  Feature: Add and delete books



    Scenario: Add a book to the collection
      Given user is logged in
      Given user is on the Book Store page
      When user clicks the link of "You Don't Know JS" in the book title column
      Then user should be land on the page of selected book
      When user clicks add to your collection button
      And user accepts alert
      Then added book named "You Don't Know JS" should listed profile page



    Scenario: Delete a book from the collection
      Given user is logged in
      When user clicks the delete icon of "You Don't Know JS" in the book action column
      And user clicks the ok button to accept
      And user accepts alert
      Then the book named "You Don't Know JS" should be deleted




