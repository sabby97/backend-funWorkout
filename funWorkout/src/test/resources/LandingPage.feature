Feature: Landing page functionality

  #MVP
  Scenario: A random workout can be generated while not logged in
    Given User is on the landing page
    And User is not logged in
    When User requests a random workout routine
    Then User focuses on a randomly generated workout

  #MVP
  Scenario: Log in function works when valid user credentials are used
    Given User is on the landing page
    And User is not logged in
    When User inputs valid username
    And User inputs matching valid password
    And User clicks login
    Then User becomes logged in

  #MVP
  Scenario: Log in fails when an invalid username is used
    Given User is on the landing page
    And User is not logged in
    When User inputs an invalid username
    And User inputs matching valid password
    And User clicks login
    Then User sees invalid login info message
    And User does not log in

  #MVP
  Scenario: Log in fails when an invalid password is used
    Given User is on the landing page
    And User is not logged in
    When User inputs valid username
    And User inputs invalid password
    And User clicks login
    Then User sees invalid login info message
    And User does not log in


  Scenario: A new user profile can be created
    Given User is on the landing page
    And User is not logged in
    When User inputs a username
    And User inputs a password
    And User clicks submit new user info
    Then A new user account is created

  Scenario: A new user profile is invalid and not created
    Given User is on the landing page
    And User is not logged in
    When User inputs a username matching an existing username
    And User inputs a password
    And User clicks submit new user info
    Then User sees invalid username info message


#  Scenario: A user is able to start a workout
#    Given User is on the landing page
#    And User is focused on a workout
#    When User clicks start workout
#    Then User sees the workout display which exercise to do when

#  Scenario: A random recommended workout can be generated while not logged in
#    Given User is on the landing page
#    And User is not logged in
#    When User requests a random recommended workout routine
#    Then User focuses on a random workout from the database that is recommended
