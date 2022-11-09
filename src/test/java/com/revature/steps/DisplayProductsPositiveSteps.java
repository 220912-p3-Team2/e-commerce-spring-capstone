package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class DisplayProductsPositiveSteps {
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    @When("The user is on the search for products page")
    public void theUserIsOnTheSearchForProductsPage() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
    }

    @Then("The user should see all the products available")
    public void theUserShouldSeeAllTheProductsAvailable() {
        assertEquals("Computer",driver.findElement(By.xpath("//h5[contains(text(), 'Computer')]")).getText());
        assertEquals("YoYo",driver.findElement(By.xpath("//h5[contains(text(), 'YoYo')]")).getText());
    }

}
