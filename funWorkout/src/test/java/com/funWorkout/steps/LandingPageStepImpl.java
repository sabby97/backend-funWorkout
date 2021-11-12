package com.funWorkout.steps;

import com.funWorkout.pages.FunWorkoutMain;
import com.funWorkout.runners.FunWorkoutRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LandingPageStepImpl {

    public static FunWorkoutMain funWorkoutMain = FunWorkoutRunner.funWorkoutMain;
    public static WebDriver driver = FunWorkoutRunner.driver;

    // Scenario: A random workout can be generated while not logged in
    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        driver.get("http://localhost:4200/");
    }
    @Given("User is not logged in")
    public void user_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User requests a random workout routine")
    public void user_requests_a_random_workout_routine() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a randomly generated workout")
    public void user_focuses_on_a_randomly_generated_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A random recommended workout can be generated while not logged in
    @When("User requests a random recommended workout routine")
    public void user_requests_a_random_recommended_workout_routine() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User focuses on a random workout from the database that is recommended")
    public void user_focuses_on_a_random_workout_from_the_database_that_is_recommended() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: Log in function works when valid user credentials are used
    @When("User inputs valid username")
    public void user_inputs_valid_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User inputs matching valid password")
    public void user_inputs_inputs_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks login")
    public void user_clicks_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User is logged in")
    public void user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions

    }


    // Scenario: Log in fails when an invalid username is used
    @When("User inputs an invalid username")
    public void user_inputs_an_invalid_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User does not log in")
    public void user_does_not_log_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees invalid login info message")
    public void user_sees_invalid_login_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: Log in fails when an invalid password is used
    @When("User inputs invalid password")
    public void user_inputs_invalid_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A new user profile can be created
    @When("User clicks on create new user")
    public void user_clicks_on_create_new_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User inputs a username")
    public void user_inputs_a_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User inputs a password")
    public void user_inputs_a_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks submit new user info")
    public void user_clicks_submit_new_user_info() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("A new user account is created")
    public void a_new_user_account_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    // Scenario: A new user profile is invalid and not created
    @When("User inputs a username matching an existing username")
    public void user_inputs_a_username_matching_an_existing_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("No user account is created")
    public void no_user_account_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees invalid username info message")
    public void user_sees_invalid_username_info_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    // Scenario: A user is able to start a workout
    @Given("User is focused on a workout")
    public void user_is_focused_on_a_workout() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("User clicks start workout")
    public void user_clicks_start_workout() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User sees the workout display which exercise to do when")
    public void user_sees_the_workout_display_which_exercise_to_do_when() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }










}
