package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class ModifyCartSteps {
        WebDriver driver = Runner.driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions action = new Actions(driver);

        @Given("user is logged in and on the product page")
        public void userIsLoggedInAndOnTheProductPage() {
                driver.navigate().to("http://localhost:3000/");
                wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
                driver.findElement(By.id("email")).sendKeys("admin2@example.com");
                driver.findElement(By.id("password")).sendKeys("hunter2");
                driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
        }

        @When("The user adds a product to cart")
        public void theUserAddsAProductToCart() {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
                WebElement product = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]"));
                action.moveToElement(product).click().build().perform();

        }

        @When("The user clicks on cart symbol")
        public void theUserClicksOnCartSymbol() {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("/html/body/div/div[1]/div/div[2]/div[4]")));
                WebElement cart = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
                action.moveToElement(cart).click().build().perform();

        }

        @Then("The user sees added product")
        public void theUserSeesAddedProduct() {
                wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button")));
                assertEquals("CHECKOUT NOW",
                                driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button"))
                                                .getText());
                driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
        }

        @Given("user is logged in and on the product page again")
        public void userIsLoggedInAndOnTheProductPageCartAgain() {
                driver.navigate().to("http://localhost:3000/");
                wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
                driver.findElement(By.id("email")).sendKeys("admin2@example.com");
                driver.findElement(By.id("password")).sendKeys("hunter2");
                driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
        }

        @When("The user adds a product to cart again")
        public void theUserAddsAProductToCartAgain() {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
                WebElement product = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]"));
                action.moveToElement(product).click().build().perform();

        }

        @When("The user clicks on cart symbol again")
        public void theUserClicksOnCartSymbolAgain() {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("/html/body/div/div[1]/div/div[2]/div[4]")));
                WebElement cart = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
                action.moveToElement(cart).click().build().perform();

        }

        @When("The user removes product")
        public void theUserRemovesProduct() {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[2]")));
                driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[2]"))
                                .click();
        }

        @Then("The user sees the product removed from cart")
        public void theUserSeesTheProductRemovedFromCart() {
                wait.until(ExpectedConditions
                                .elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button")));
                assertEquals("CONTINUE SHOPPING",
                                driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button")).getText());
                driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/li/strong")).click();
        }

        @Given("The user is on cart page with product in cart")
        public void theUserIsOnCartPageWithProductInCart() {
                driver.navigate().to("http://localhost:3000/");
                wait.until(
                                ExpectedConditions.elementToBeClickable(
                                                By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")));
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[2]/strong")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/main/div/form/button")));
                driver.findElement(By.id("email")).sendKeys("admin2@example.com");
                driver.findElement(By.id("password")).sendKeys("hunter2");
                driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/form/button")).click();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("//*[@id=\"root\"]/div[3]/div[2]/div/div[2]/div/div[1]/h5")));
                WebElement product = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]"));
                action.moveToElement(product).click().build().perform();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                                By.xpath("/html/body/div/div[1]/div/div[2]/div[4]")));
                WebElement cart = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[4]"));
                action.moveToElement(cart).click().build().perform();

        }

        @When("The user changes quantity of the product")
        public void theUserChangesQuantityOfTheProduct() {
                wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[3]")));
                WebElement quantityUp = driver.findElement(
                                By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[3]"));
                quantityUp.click();
                quantityUp.click();
                WebElement quantityDown = driver.findElement(
                                By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
                quantityDown.click();
        }

        @Then("The user sees updated quantity")
        public void theUserSeesUpdatedQuantity() {
                String quantity = driver.findElement(
                                By.xpath("/html/body/div/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/div"))
                                .getText();
                assertEquals("2", quantity);
                System.out.println("After raising quantity twice then lowering it once the quantity is " + quantity);
        }
}
