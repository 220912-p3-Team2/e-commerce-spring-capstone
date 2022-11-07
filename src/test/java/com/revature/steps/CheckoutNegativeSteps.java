package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutNegativeSteps {

    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    @Then("The user can’t checkout no products")
    public void theUserCanTCheckoutNoProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")));
        assertEquals("CONTINUE SHOPPING", driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")).getText());
    }
}
