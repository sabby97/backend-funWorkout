Feature: Additional functionality for logged in users

  #MVP
  Scenario: A logged in user is able to logout
    Given User is logged in
    When User clicks on logout button
    Then User is not logged in

  #MVP
  Scenario: A workout is generated with simple parameters
    Given User is logged in
    When User inputs difficulty options
    And User requests a new workout
    Then User focuses on a generated workout in line with difficulty option

  Scenario: A workout is generated with complex parameters
    Given User is logged in
    When User inputs difficulty options
    And User inputs additional parameters
    And User requests a new workout
    Then User focuses on a generated workout in line with difficulty and parameter options

  #MVP
  Scenario: A focused workout is saved
    Given User is logged in
    And User is focused on a workout
    When User inputs a name for the workout
    And User saves the workout
    Then The workout is saved under the entered name
    And User sees workout saved info message

  #MVP
  Scenario: A previously saved focused workout is saved
    Given User is logged in
    And User is focused on a workout
    And The workout already exists in the database
    When User saves the workout
    Then The workout is updated in the database
    And User sees workout saved info message

  #MVP
  Scenario: A saved workout is deleted
    Given User is logged in
    And User is focused on a saved workout
    When User clicks delete workout
    Then The workout is deleted from the database
    And The user sees workout deleted message

  Scenario: A user is able to like a viewed workout
    Given User is logged in
    And User is focused on a workout
    When User selects like workout
    Then The workout is updated in the database to have an additional like
    And User sees the updated rating


  #MVP
  Scenario: Saved workouts are viewed in a list
    Given User is logged in
    When User selects view saved workouts
    Then User focuses on a list of saved workouts

  Scenario: A user is able to view a list of recommended workouts
    Given User is logged in
    When User clicks on view recommended workouts
    Then User focuses on a list of recommended workouts

  Scenario: User is able to search for a workout based on parameters
    Given User is logged in
    When User inputs search parameters
    And User clicks search
    Then User focuses on a list of workouts found based on search parameters

  #MVP
  Scenario: A user is able to focus on a workout from a list
    Given User is logged in
    And User is focused on a list of workouts
    When User selects a recommended workout
    Then User focuses on the selected recommended workout


  Scenario: A workout is edited by removing an exercise
    Given User is logged in
    And User is focused on a workout
    When User clicks removes exercise on a specific exercise
    Then User sees that the focused workout no longer contains the exercise

  Scenario: A workout is edited by adding an exercise
    Given User is logged in
    And User is focused on a workout
    When User optionally edits desired workout parameters
    And User clicks add an exercise from the workout
    Then User sees that the focused workout contains a new exercise

  Scenario: A workout is edited by reordering an exercise
    Given User is logged in
    And User is focused on a workout
    When User selects an exercise
    And User selects where in the workout the exercise should be
    Then User sees that the focused workout has been reordered










