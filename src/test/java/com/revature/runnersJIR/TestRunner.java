package com.revature.runnersJIR;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources"}, glue={"com.revature.steps"})

public class TestRunner {
    public static WebDriver driver = null;

//    @Test
//    public static void loginAPITest(){
//        given().queryParam("email","test@test.test")
//                .queryParam("password","7est!nCj")
//                .when().get("http://localhost:3000/auth/login").then().assertThat().statusCode(200);
//   }
    @BeforeClass
    public static void setup(){
//        loginAPITest();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void endTests()
    {
        driver.close();
    }
}
