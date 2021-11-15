package com.funWorkout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FunWorkoutMain {

    public WebDriver driver;

    public FunWorkoutMain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Sign-in-out component
    @FindBy(id = "signin-body")
    public WebElement logInUserPanel;
    @FindBy(id = "userInput")
    public WebElement loginInUsernameInput;
    @FindBy(id = "passwordInput")
    public WebElement loginInPasswordInput;
    @FindBy(id = "signInButton")
    public WebElement signInButton;
    @FindBy(id = "signOutButton")
    public WebElement signOutButton;
    @FindBy(id = "signUpButton")
    public WebElement signUpButton;



    //Random-workout component
    @FindBy(id = "generateButton")
    public WebElement generateRandomWorkoutButton;


    //Workout-focus component
    @FindBy(id = "mat-expansion-panel-header-2")
    public WebElement sampleWorkoutFocusDivRand;
    @FindBy(id = "mat-expansion-panel-header-4")
    public WebElement sampleWorkoutFocusDivRandLoggedIn;
    @FindBy(id = "focus-card")
    public WebElement sampleWorkoutFocusDiv;
    @FindBy(id = "intensitySpan2")
    public WebElement exerciseSpan3;
    @FindBy(id = "intensitySpan1")
    public WebElement exerciseSpan2;
    @FindBy(id = "intensitySpan0")
    public WebElement exerciseSpan1;
    @FindBy(id = "saveWorkoutNameInput")
    public WebElement saveWorkoutNameInput;

    //user-buttons component
    @FindBy(id = "saveWorkoutButton")
    public WebElement saveWorkoutButton;
    @FindBy(id = "deleteWorkoutButton")
    public WebElement deleteWorkoutButton;


    //Custom-workout component
    @FindBy(id="mat-expansion-panel-header-1")
    public WebElement customWorkoutPanel;
    @FindBy(id="minIntensityInput")
    public WebElement minIntensityInput;
    @FindBy(id="createCustomWorkoutButton")
    public WebElement createCustomWorkoutButton;
    @FindBy(id="warmUpCheckbox")
    public WebElement warmUpCheckbox;


    //Workout-plan display component
    @FindBy(id="mat-expansion-panel-header-3")
    public WebElement planListDisplayPanel;
    @FindBy(id="select-button0")
    public WebElement selectButton0;
    @FindBy(id="select-button2")
    public WebElement selectButton2;


    @FindBy(id="userWorkoutTable")
    public WebElement userWorkoutTable;
    @FindBy(id="recommendedWorkoutTable")
    public WebElement recommendedWorkoutTable;



}
