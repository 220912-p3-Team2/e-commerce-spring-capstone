package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CartSteps {
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    Actions action = new Actions(driver);
    @When("The user adds a product to cart")
    public void theUserAddsAProductToCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
        WebElement yoyo = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]"));
        action.moveToElement(yoyo).click().build().perform();



    }

    @When("The user clicks on cart symbol")
    public void theUserClicksOnCartSymbol() {
        WebElement cart = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
        action.moveToElement(cart).click().build().perform();

    }

    @Then("The user sees added product")
    public void theUserSeesAddedProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button")));
        assertEquals("CHECKOUT NOW",driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button")).getText());
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
    }

    @When("The user removes product")
    public void theUserRemovesProduct() {
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]")).click();
    }

    @Then("The user sees the product removed from cart")
    public void theUserSeesTheProductRemovedFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")));
        assertEquals("CONTINUE SHOPPING", driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button")).getText());
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
    }
}
