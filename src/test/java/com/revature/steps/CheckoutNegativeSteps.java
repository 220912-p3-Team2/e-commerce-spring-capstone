package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutNegativeSteps {

    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    Actions action = new Actions(driver);
    @Then("The user can’t checkout no products")
    public void theUserCanTCheckoutNoProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")));
        assertEquals("CONTINUE SHOPPING", driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")).getText());
    }

    @When("The user adds an out of stock product into the cart")
    public void theUserAddsAnOutOfStockProductIntoTheCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
        WebElement pcAdd = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/div[1]/div[1]"));
        action.moveToElement(pcAdd).click().build().perform();

    }

    @Then("The user should not be able to successfully buy the out of stock product")
    public void theUserShouldNotBeAbleToSuccessfullyBuyTheOutOfStockProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/h6")));
        assertEquals("Product Out of Stock.", driver.findElement(By.xpath("/html/body/div/main/div/h5")).getText());
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
    }
}
