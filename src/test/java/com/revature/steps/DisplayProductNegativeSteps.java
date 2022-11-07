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

public class DisplayProductNegativeSteps {

    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        driver.navigate().to("http://localhost:3000/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
        driver.findElement(By.id("email")).sendKeys("admin2@example.com");
        driver.findElement(By.id("password")).sendKeys("hunter2");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));

    }

    @When("The user types in a nonexistent product in search bar")
    public void theUserTypesInANonexistentProductInSearchBar() {
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input")).sendKeys("example");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[3]")));

    }

    @Then("The user should not see the product")
    public void theUserShouldNotSeeTheProduct() {
        assertEquals("Congo",driver.getTitle());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/li/strong")).click();
    }
}
