package com.funWorkout.steps;

import com.funWorkout.pages.FunWorkoutMain;
import com.funWorkout.runners.FunWorkoutRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UserProfileStepImpl {

    public static FunWorkoutMain funWorkoutMain = FunWorkoutRunner.funWorkoutMain;
    public static WebDriver driver = FunWorkoutRunner.driver;

    // Scenario: A logged in user is able to logout
    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A workout is generated with simple parameters
    @When("User inputs difficulty options")
    public void user_inputs_difficulty_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User requests a new workout")
    public void user_requests_a_new_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a generated workout in line with difficulty option")
    public void user_focuses_on_a_generated_workout_in_line_with_difficulty_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A workout is generated with complex parameters
    @When("User inputs additional parameters")
    public void user_inputs_additional_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a generated workout in line with difficulty and parameter options")
    public void user_focuses_on_a_generated_workout_in_line_with_difficulty_and_parameter_options() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A focused workout is saved
    @When("User inputs a name for the workout")
    public void user_inputs_a_name_for_the_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User saves the workout")
    public void user_saves_the_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The workout is saved under the entered name")
    public void the_workout_is_saved_under_the_entered_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees workout saved info message")
    public void user_sees_workout_saved_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A previously saved focused workout is saved
    @Given("The workout already exists in the database")
    public void the_workout_already_exists_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The workout is updated in the database")
    public void the_workout_is_updated_in_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A saved workout is deleted
    @Given("User is focused on a saved workout")
    public void user_is_focused_on_a_saved_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks delete workout")
    public void user_clicks_delete_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The workout is deleted from the database")
    public void the_workout_is_deleted_from_the_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The user sees workout deleted message")
    public void the_user_sees_workout_deleted_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    //Scenario: A user is able to like a viewed workout
    @When("User selects like workout")
    public void user_selects_like_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The workout is updated in the database to have an additional like")
    public void the_workout_is_updated_in_the_database_to_have_an_additional_like() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the updated rating")
    public void user_sees_the_updated_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: Saved workouts are viewed in a list
    @When("User selects view saved workouts")
    public void user_selects_view_saved_workouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a list of saved workouts")
    public void user_focuses_on_a_list_of_saved_workouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A user is able to view a list of recommended workouts
    @When("User clicks on view recommended workouts")
    public void user_clicks_on_view_recommended_workouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a list of recommended workouts")
    public void user_focuses_on_a_list_of_recommended_workouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: User is able to search for a workout based on parameters
    @When("User inputs search parameters")
    public void user_inputs_search_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks search")
    public void user_clicks_search() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a list of workouts found based on search parameters")
    public void user_focuses_on_a_list_of_workouts_found_based_on_search_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A user is able to focus on a workout from a list
    @Given("User is focused on a list of workouts")
    public void user_is_focused_on_a_list_of_workouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User selects a recommended workout")
    public void user_selects_a_recommended_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on the selected recommended workout")
    public void user_focuses_on_the_selected_recommended_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A workout is edited by removing an exercise
    @When("User clicks removes exercise on a specific exercise")
    public void user_clicks_removes_exercise_on_a_specific_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees that the focused workout no longer contains the exercise")
    public void user_sees_that_the_focused_workout_no_longer_contains_the_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A workout is edited by adding an exercise
    @When("User optionally edits desired workout parameters")
    public void user_optionally_edits_desired_workout_parameters() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks add an exercise from the workout")
    public void user_clicks_add_an_exercise_from_the_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees that the focused workout contains a new exercise")
    public void user_sees_that_the_focused_workout_contains_a_new_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A workout is edited by reordering an exercise
    @When("User selects an exercise")
    public void user_selects_an_exercise() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User selects where in the workout the exercise should be")
    public void user_selects_where_in_the_workout_the_exercise_should_be() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees that the focused workout has been reordered")
    public void user_sees_that_the_focused_workout_has_been_reordered() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
