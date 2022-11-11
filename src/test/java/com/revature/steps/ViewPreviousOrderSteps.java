package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewPreviousOrderSteps {
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @Given("user is logged in and on the home page")
    public void userIsLoggedInAndOnTheHomePage() {
        driver.navigate().to("http://localhost:3000/");
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
        driver.findElement(By.id("email")).sendKeys("admin2@example.com");
        driver.findElement(By.id("password")).sendKeys("hunter2");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
    }

    @When("user clicks on Orders button")
    public void userClicksOnOrdersButton() {
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]/strong")));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]/strong")).click();

    }

    @Then("user is taken to the orders page where previous orders are displayed")
    public void userIsTakenToTheOrdersPageWherePreviousOrdersAreDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[4]/div[1]")));
        boolean displayed = driver.findElement(By.xpath("/html/body/div/div[4]/div[1]")).isDisplayed();
        if (displayed == true) {
            System.out.println("Orders page is displayed");
        } else {
            System.out.println("Orders page is not displayed");
        }
    }
}
