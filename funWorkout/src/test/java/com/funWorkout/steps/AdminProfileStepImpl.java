package com.funWorkout.steps;

import com.funWorkout.pages.FunWorkoutMain;
import com.funWorkout.runners.FunWorkoutRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AdminProfileStepImpl {

    public static FunWorkoutMain funWorkoutMain = FunWorkoutRunner.funWorkoutMain;
    public static WebDriver driver = FunWorkoutRunner.driver;


    //Scenario: An admin is able to view an exercise in the database
    @Given("User is an admin")
    public void user_is_an_admin() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User selects an exercise to view")
    public void user_selects_an_exercise_to_view() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the exercise details")
    public void user_sees_the_exercise_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: An admin is able to add a new exercise to the database
    @When("User clicks on add exercise button")
    public void user_clicks_on_add_exercise_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User inputs exercise parameters")
    public void user_inputs_exercise_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks add exercise")
    public void user_clicks_add_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Exercise is added to the database")
    public void exercise_is_added_to_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees exercise added info message")
    public void user_sees_exercise_added_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: An admin is able to update an exercise in the database
    @When("User is viewing the details of an exercise")
    public void user_is_viewing_the_details_of_an_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User modifies exercise parameters")
    public void user_modifies_exercise_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks update exercise")
    public void user_clicks_update_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Exercise is edited in the database")
    public void exercise_is_edited_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees exercise updated info message")
    public void user_sees_exercise_updated_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: An admin is able to delete an exercise in the database
    @When("User clicks delete exercise")
    public void user_clicks_delete_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Exercise is deleted from the database")
    public void exercise_is_deleted_from_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees exercise deleted info message")
    public void user_sees_exercise_deleted_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: An admin is able to recommend one of their workouts
    @Given("User is viewing a saved workout")
    public void user_is_viewing_a_saved_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("That workout is not recommended")
    public void that_workout_is_not_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User selects recommend workout")
    public void user_selects_recommend_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Workout is modified in the database as recommended")
    public void workout_is_modified_in_the_database_as_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the workout was recommended")
    public void user_sees_the_workout_was_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: An admin is able to rescind one of their workouts
    @Given("That workout is recommended")
    public void that_workout_is_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User selects rescind workout")
    public void user_selects_rescind_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Workout is modified in the database as not recommended")
    public void workout_is_modified_in_the_database_as_not_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the workout was unrecommended")
    public void user_sees_the_workout_was_unrecommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
