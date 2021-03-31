Feature: Create Account
  I want to use this feature to test the login function of a website.

  Background:
    Given open a new CHROME browser
    And navigate to website
    And we are on the correct webpage
    And header text is correct


  Scenario Outline: create a user -- happy flow
    When enter <valid> email
    And enter <valid> username
    And enter password
    Then press sign up button
    And verify you are on completed signup page
    And close browser

    Examples:
      | valid |
      | valid |

  Scenario Outline: create a user invalid information
    When enter <email> email
    And enter <username> username
    And enter password
    Then press sign up button
    And verify error <error>
    And close browser

    Examples:
      | email   | username | error            |
      | valid   | invalid  | username to long |
      | valid   | taken    | username taken   |
      | invalid | valid    | email missing    |