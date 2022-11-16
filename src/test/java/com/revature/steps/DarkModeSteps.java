package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DarkModeSteps {
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @Given("user is on the home page and light mode is on")
    public void userIsOnTheHomePageAndLightModeIsOn() {
        driver.navigate().to("http://localhost:3000/");
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
        driver.findElement(By.id("email")).sendKeys("admin2@example.com");
        driver.findElement(By.id("password")).sendKeys("hunter2");
        driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();

    }

    @When("user clicks dark mode button")
    public void userClicksDarkModeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/span/span[1]")));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/span/span[1]")).click();
    }

    @When("user clicks dark mode button again")
    public void userClicksDarkModeButtonAgain() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/span/span[1]")));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/span/span[1]")).click();
    }

    @Then("dark mode is turned on and off")
    public void darkModeIsTurnedOff() {
        WebElement body = driver.findElement(By.tagName("body"));
        wait.until(ExpectedConditions.attributeToBe(body, "background-color", "rgba(18, 18, 18, 1)"));
        System.out.println("Dark mode color is " + body.getCssValue("background-color"));
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/span/span[1]/span[1]/input")).click();
        System.out.println("Light mode color is " + body.getCssValue("background-color"));
    }
}
