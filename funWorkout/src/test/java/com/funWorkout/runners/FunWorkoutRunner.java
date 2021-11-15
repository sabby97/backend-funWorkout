package com.funWorkout.runners;

import com.funWorkout.pages.FunWorkoutMain;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"com.funWorkout.steps"})
public class FunWorkoutRunner {

    public static WebDriver driver;
    public static FunWorkoutMain funWorkoutMain;

    @BeforeClass
    public static void setup() {
        String path = "C:/Users/ryans/Documents/selenium_drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);

        driver = new ChromeDriver();
        funWorkoutMain = new FunWorkoutMain(driver);

    }


    @AfterClass
    public static void teardown() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
