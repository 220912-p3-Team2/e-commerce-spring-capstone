package com.revature.Runner;

import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeaturesDCC/DarkMode.feature", glue = "com.revature.steps")
public class Runner {

    public static ChromeDriver driver;

    @BeforeClass
    public static void setup() {
        File chrome = new File("src/test/resources/Driver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
