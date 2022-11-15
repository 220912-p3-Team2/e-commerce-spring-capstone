package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class CheckoutPositiveSteps {
    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    @When("The user clicks on checkout")
    public void theUserClicksOnCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button")));
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button")).click();
    }

    @When("The user types in information for Shipping Address")
    public void theUserTypesInInformationForShippingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/form/div[2]/button")));
        driver.findElement(By.id("firstName")).sendKeys("N");
        driver.findElement(By.id("lastName")).sendKeys("C");
        driver.findElement(By.id("address1")).sendKeys("900 Main St");
        driver.findElement(By.id("city")).sendKeys("Richmond");
        driver.findElement(By.id("state")).sendKeys("VA");
        driver.findElement(By.id("zip")).sendKeys("23220");
        driver.findElement(By.id("country")).sendKeys("US");
    }

    @When("The user clicks Next")
    public void theUserClicksNext() {
        driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/button")).click();
    }

    @When("The user chooses payment method")
    public void theUserChoosesPaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/form/div/button[1]")));
        driver.findElement(By.xpath("/html/body/div/main/div/form/div/div/table/tr/label/span[1]/input")).click();
    }

    @When("The user clicks Submit Payment")
    public void theUserClicksSubmitPayment() {
        driver.findElement(By.xpath("/html/body/div/main/div/form/div/button[1]")).click();
    }

    @When("The user clicks Place Order")
    public void theUserClicksPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/main/div/div[3]/button[2]")));
        driver.findElement(By.xpath("/html/body/div/main/div/div[3]/button[2]")).click();
    }

    @Then("The user successfully ordered the products")
    public void theUserSuccessfullyOrderedItems() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/h6")));
        assertEquals("Thank you for your order.", driver.findElement(By.xpath("/html/body/div/main/div/h5")).getText());
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
    }
}
