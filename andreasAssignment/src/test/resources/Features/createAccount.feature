Feature: Create Account
  I want to use this feature to test the login function of a website.

  Scenario Outline: create a user invalid information
    Given open a new CHROME browser
    And navigate to website
    And we are on the correct webpage
    And we accept cookies
    And header text is correct
    When enter <email> email
    And enter <username> username
    And enter password
    Then press sign up button
    And verify event <event>
    And close browser

    Examples:
      | email   | username | event            |
      | VALID   | VALID  | signup page |
      | VALID   | INVALID  | username to long |
      | VALID   | TAKEN    | username taken   |
      | INVALID | VALID    | email missing    |