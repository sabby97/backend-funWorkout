package com.funWorkout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FunWorkoutMain {

    public WebDriver driver;

    public FunWorkoutMain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
