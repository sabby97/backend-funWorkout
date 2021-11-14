Feature: Additional functionality for logged in admin users

  Scenario: An admin is able to view an exercise in the database
    Given User is logged in
    And User is an admin
    When User selects an exercise to view
    Then User sees the exercise details

  #MVP
  Scenario: An admin is able to add a new exercise to the database
    Given User is logged in
    And User is an admin
    When User clicks on add exercise button
    And User inputs exercise parameters
    And User clicks add exercise
    Then Exercise is added to the database
    And User sees exercise added info message

  Scenario: An admin is able to update an exercise in the database
    Given User is logged in
    And User is an admin
    When User is viewing the details of an exercise
    And User modifies exercise parameters
    And User clicks update exercise
    Then Exercise is edited in the database
    And User sees exercise updated info message

  #MVP
  Scenario: An admin is able to delete an exercise in the database
    Given User is logged in
    And User is an admin
    When User is viewing the details of an exercise
    And User clicks delete exercise
    Then Exercise is deleted from the database
    And User sees exercise deleted info message


  Scenario: An admin is able to recommend one of their workouts
    Given User is logged in
    And User is an admin
    And User is viewing a saved workout
    And That workout is not recommended
    When User selects recommend workout
    Then Workout is modified in the database as recommended
    And User sees the workout was recommended

  Scenario: An admin is able to rescind one of their workouts
    Given User is logged in
    And User is an admin
    And User is viewing a saved workout
    And That workout is recommended
    When User selects rescind workout
    Then Workout is modified in the database as not recommended
    And User sees the workout was unrecommended


