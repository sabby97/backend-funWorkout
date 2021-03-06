package com.funWorkout.steps;

import com.funWorkout.pages.FunWorkoutMain;
import com.funWorkout.runners.FunWorkoutRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LandingPageStepImpl {

    public static FunWorkoutMain funWorkoutMain = FunWorkoutRunner.funWorkoutMain;
    public static WebDriver driver = FunWorkoutRunner.driver;

    JavascriptExecutor jsExe = (JavascriptExecutor) driver;


    // Scenario: A random workout can be generated while not logged in
    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        driver.get("http://localhost:4200/");
    }
    @Given("User is not logged in")
    public void user_is_not_logged_in() {
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.clear();
    }
    @When("User requests a random workout routine")
    public void user_requests_a_random_workout_routine() {
        funWorkoutMain.generateRandomWorkoutButton.click();
    }
    @Then("User focuses on a randomly generated workout")
    public void user_focuses_on_a_randomly_generated_workout() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.sampleWorkoutFocusDivRand.isEnabled());
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
        funWorkoutMain.logInUserPanel.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.loginInUsernameInput.isEnabled());
        funWorkoutMain.loginInUsernameInput.sendKeys("gymleader");
    }
    @When("User inputs matching valid password")
    public void user_inputs_inputs_valid_password() {
        funWorkoutMain.loginInPasswordInput.sendKeys("guest");
    }
    @When("User clicks login")
    public void user_clicks_login() {
        funWorkoutMain.signInButton.click();
    }
    @Then("User becomes logged in")
    public void user_becomes_logged_in() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.signOutButton.isEnabled());

        String expectedUsername = "gymleader";
        Assert.assertEquals(expectedUsername, (String) jsExe.executeScript("return localStorage.getItem('userName')"));

    }


    // Scenario: Log in fails when an invalid username is used
    @When("User inputs an invalid username")
    public void user_inputs_an_invalid_username() {
        funWorkoutMain.logInUserPanel.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.loginInUsernameInput.isEnabled());
        funWorkoutMain.loginInUsernameInput.sendKeys("gymleaderFAKE");
    }
    @Then("User sees invalid login info message")
    public void user_sees_invalid_login_info_message() {

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        driver.switchTo().alert().dismiss();
        String expectedTest = "There is no user with these credentials.  Please try again.";
        Assert.assertEquals(alertText, expectedTest);
    }
    @Then("User does not log in")
    public void user_does_not_log_in() {
        String expectedValue = null;
        Assert.assertEquals(String.valueOf(expectedValue), jsExe.executeScript("return localStorage.getItem('userName')"));
    }



    // Scenario: Log in fails when an invalid password is used
    @When("User inputs invalid password")
    public void user_inputs_invalid_username() {
        funWorkoutMain.loginInPasswordInput.sendKeys("guestFAKE");
    }


    // Scenario: A new user profile can be created
    @When("User inputs a username")
    public void user_inputs_a_username() {
        funWorkoutMain.logInUserPanel.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.loginInUsernameInput.isEnabled());
        funWorkoutMain.loginInUsernameInput.sendKeys("newTestUser");
    }
    @When("User inputs a password")
    public void user_inputs_a_password() {
        funWorkoutMain.loginInPasswordInput.sendKeys("guestTest");
    }
    @When("User clicks submit new user info")
    public void user_clicks_submit_new_user_info() {
        funWorkoutMain.signUpButton.click();
    }
    @Then("A new user account is created")
    public void a_new_user_account_is_created() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        driver.switchTo().alert().dismiss();
        String expectedTest = "You have successfully signed up.  Please press Sign In to access your profile";
        Assert.assertEquals(alertText, expectedTest);
    }


    // Scenario: A new user profile is invalid and not created
    @When("User inputs a username matching an existing username")
    public void user_inputs_a_username_matching_an_existing_username() {
        funWorkoutMain.logInUserPanel.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(funWorkoutMain.loginInUsernameInput.isEnabled());
        funWorkoutMain.loginInUsernameInput.sendKeys("newTestUser");
    }
    @Then("User sees invalid username info message")
    public void user_sees_invalid_username_info_message() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        driver.switchTo().alert().dismiss();
        String expectedTest = "You already have an account, please select Sign In.";
        Assert.assertEquals(alertText, expectedTest);
    }

    // Scenario: A user is able to start a workout
    @Given("User is focused on a workout")
    public void user_is_focused_on_a_workout() {
        funWorkoutMain.sampleWorkoutFocusDivRandLoggedIn.click();
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
