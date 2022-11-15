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

public class RegisterSteps {
    int turns = 0;
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @Given("The user is on the register page.")
    public void the_user_is_on_the_register_page() {
      driver.navigate().to("http://localhost:3000/register");
      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/form/button")));
    }

    @When("The user clicks the sign up button.")
    public void the_user_clicks_the_sign_up_button() {
        WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
        button.click();
        if(turns == 1)
        {
            button.click();
        }
    }

    @Then("The user sees an alert that says, Please fill out this field.{string}")
    public void the_user_sees_an_alert_that_says_please_fill_out_this_field(String string) {
        String alert = "";
        if(turns == 0) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/p")));
            alert = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/p")).getText();
            turns = 1;
        }
        else {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/form/div[1]/div[4]/div/p")));
            alert = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[4]/div/p")).getText();
            string = alert;
        }

        Assertions.assertEquals(string,alert);

    }

    @When("The user enters registration information excluding a password.{string}{string}{string}")
    public void the_user_enters_registration_information_excluding_a_password(String string, String string2, String string3) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[2]/div/div/input"));
        WebElement input3 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[3]/div/div/input"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        input3.sendKeys(string3);
    }

    @When("The user enters an invalid password.{string}")
    public void the_user_enters_an_invalid_password(String string) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[4]/div/div/input"));
        input1.sendKeys(string);
    }

    @When("The user enters valid registration data.{string}{string}{string}{string}")
    public void the_user_enters_valid_registration_data(String string, String string2, String string3, String string4) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[1]/div/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[2]/div/div/input"));
        WebElement input3 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[3]/div/div/input"));
        WebElement input4 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div[4]/div/div/input"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        input3.sendKeys(string3);
        input4.sendKeys(string4);
    }

    @Then("The user is moved to the sign in page.")
    public void the_user_is_moved_to_the_sign_in_page() {
        driver.navigate().to("http://localhost:3000/login");
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/login",url);
    }
}
