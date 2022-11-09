package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class DisplayProductNegativeSteps {

    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        driver.navigate().to("http://localhost:3000/login");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
        driver.findElement(By.id("email")).sendKeys("admin2@example.com");
        driver.findElement(By.id("password")).sendKeys("hunter2");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));

    }


    @When("The user is on the product list page")
    public void theUserIsOnTheProductListPage() {
        wait.until(ExpectedConditions.titleIs("Congo"));
    }

    @Then("The user should not see product list")
    public void theUserShouldNotSeeProductList() {
        WebElement productList = driver.findElement(By.xpath("/html/body/div/div[3]"));
        assertNull(productList);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
    }
}
