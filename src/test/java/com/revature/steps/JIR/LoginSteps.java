package com.revature.steps.JIR;

import com.revature.Runner.Runner;
import com.revature.runnersJIR.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {
    String url = "";
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @Given("The user navigates to the login screen.")
    public void the_user_navigates_to_the_login_screen() {
        driver.navigate().to("http://localhost:3000/login");
    }

    @When("The user attempts to login with the incorrect login credentials.{string}{string}")
    public void the_user_attempts_to_login_with_the_incorrect_login_credentials(String string, String string2) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        button.click();
        button.click();

    }

    @Then("The user sees an alert that says, Login was unsuccessful because your account has been deactivated!{string}")
    public void the_user_sees_an_alert_that_says_login_was_unsuccessful_because_your_account_has_been_deactivated(String string) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/form/div[3]/div/div[2]")));


        String alert = driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/div/div[2]")).getText();
        Assertions.assertEquals(string, alert);
    }

    @Then("The alert closes without any further user input.")
    public void the_alert_closes_without_any_further_user_input() {
        WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/div/div[3]/button"));
        button.click();
    }

    @When("The user attempts to login with the correct login credentials.{string}{string}")
    public void the_user_attempts_to_login_with_the_correct_login_credentials(String string, String string2) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
        WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        button.click();
    }

    @Then("The users is logged in.")
    public void the_users_is_logged_in() {
     wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
     String string = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong")).getText();
     Assertions.assertEquals("PROFILE",string);
    }

    @When("the user clicks the logout button.")
    public void the_user_clicks_the_logout_button() {
        url = driver.getCurrentUrl();
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li"));
        button.click();
    }

    @Then("the user is logged out.")
    public void the_user_is_logged_out() {
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
       Assertions.assertNotEquals(driver.getCurrentUrl(),url);
    }

}
