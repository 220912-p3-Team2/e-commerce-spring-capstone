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
        assertEquals("Computer",driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")).getText());
        assertEquals("YoYo",driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div[1]/div/div[2]/div/div[1]/h5")).getText());
    }

    @When("The user types {string} in search bar")
    public void theUserTypesProductInSearchBar(String string) {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input")).sendKeys(string);
    }

    @Then("The user sees {string}")
    public void theUserSeesProductTitle(String string) {
        wait.until(ExpectedConditions.titleIs("Congo"));
        assertEquals(string,driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div/div[1]/h5")).getText());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/li/strong")).click();
    }
}
