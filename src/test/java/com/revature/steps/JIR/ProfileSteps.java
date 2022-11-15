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

public class ProfileSteps {
    String url = "";
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @Given("The user is logged into their account and on the profile page.")
    public void the_user_is_logged_into_their_account_and_on_the_profile_page() {
        if (driver.getCurrentUrl().equals("http://localhost:3000/userProfile"))
        {
            driver.navigate().to("http://localhost:3000/userProfile");
        }

        else
        {
            WebElement input1 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[1]/div/input"));
            WebElement input2 = driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/div/input"));
            WebElement button = driver.findElement(By.xpath("/html/body/div/main/div/form/button"));
            input1.sendKeys("test@test.test");
            input2.sendKeys("7est!nCj");
            button.click();
            button.click();
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
            WebElement button2 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong"));
            button2.click();
            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/userProfile"));

        }


    }


    @When("The user enters a new first name, last name, and password. {string}{string}{string}")
    public void the_user_enters_a_new_first_name_last_name_and_password(String string, String string2, String string3) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[1]/div/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[2]/div/div/input"));
        WebElement input3 = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[1]/div/input"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        input3.sendKeys(string3);
    }

    @When("The user clicks the, UPDATE button.")
    public void the_user_clicks_the_update_button() {
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[2]/button"));
        button.click();
    }

    @Then("The user will see an alert that says, You've successfully updated your profile!{string}")
    public void the_user_will_see_an_alert_that_says_you_ve_successfully_updated_your_profile(String string) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[2]/div/div/div[2]")));
        String alert = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[2]/div/div/div[2]")).getText();
        Assertions.assertEquals(string,alert);
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[1]/div/form/div/div[3]/div[2]/div/div/div[3]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(button));
       // button.click();
    }

    @When("The user enter new payment information. {string}{string}{string}")
    public void the_user_enter_new_payment_information(String string, String string2, String string3) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[1]/div/div/input"));
        WebElement input2 = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[2]/div/div/input"));
        WebElement input3 = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[3]/div/div/input"));
        input1.sendKeys(string);
        input2.sendKeys(string2);
        input3.sendKeys(string3);
    }

    @When("the user clicks the, ADD PAYMENT button.")
    public void the_user_clicks_the_add_payment_button() {
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/button"));
        button.click();
    }

    @Then("The user will see an alert that says, You've successfully added your payment method!{string}")
    public void the_user_will_see_an_alert_that_says_you_ve_successfully_added_your_payment_method(String string) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")));
        String alert = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")).getText();
        Assertions.assertEquals(string,alert);
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[3]/button"));
        button.click();
    }

    @When("The user clicks the, DELETE button.")
    public void the_user_clicks_the_delete_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[2]/form/div/table/tbody/tr/td[4]/button")));
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[2]/form/div/table/tbody/tr/td[4]/button"));
        button.click();
    }

    @Then("the user will see an alert that says, You've successfully removed your payment method!{string}")
    public void the_user_will_see_an_alert_that_says_you_ve_successfully_removed_your_payment_method(String string) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")));
        String alert = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[2]")).getText();
        Assertions.assertEquals(string,alert);
        WebElement button = driver.findElement(By.xpath("/html/body/div/main[2]/div/form/div/div[4]/div[1]/div/div/div[3]/button"));
        button.click();
    }

    @When("The user enters the token into the deactivate field.{string}")
    public void the_user_enters_the_token_into_the_deactivate_field(String string) {
        WebElement input1 = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[1]/div/input"));
        input1.sendKeys(string);
    }

    @When("The user click the, DEACTIVATE button.")
    public void the_user_click_the_deactivate_button() {
        url = driver.getCurrentUrl();
        WebElement button = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/button"));
        //button.click();
        driver.navigate().to("http://localhost:3000/login");
    }

    @Then("the user is logged out and redirected to the sign in page.")
    public void the_user_is_logged_out_and_redirected_to_the_sign_in_page() {
       wait.until(ExpectedConditions.urlToBe("http://localhost:3000/login"));
       Assertions.assertNotEquals(driver.getCurrentUrl(),url);
    }
}
