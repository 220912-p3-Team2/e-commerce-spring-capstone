package com.revature.Runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/createUpdateProductPage.feature", "src/test/resources/features/notifications.feature",
        "src/test/resources/features/resetPassword.feature"}, glue={"com.revature.steps"})
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
