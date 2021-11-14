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
    @FindBy(id = "logInUserPanel")
    public WebElement logInUserPanel;
    @FindBy(id = "userInput")
    public WebElement loginInUsernameInput;
    @FindBy(id = "passwordInput")
    public WebElement loginInPasswordInput;
    @FindBy(id = "signInButton")
    public WebElement signInButton;
    @FindBy(id = "signOutButton")
    public WebElement signOutButton;


    //Random-workout component
    @FindBy(id = "generateRandomWorkoutButton")
    public WebElement generateRandomWorkoutButton;


    //Workout-focus component
    @FindBy(id = "sampleWorkoutFocusDiv")
    public WebElement sampleWorkoutFocusDiv;
    @FindBy(id = "idExists")
    public WebElement idExists;


}
