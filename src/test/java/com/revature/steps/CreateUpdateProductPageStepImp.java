package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties;

import java.util.ArrayList;

public class CreateUpdateProductPageStepImp {
    ChromeDriver driver = Runner.driver;

    @Given("the user is logged in as admin")
    public void the_user_is_logged_in_as_admin() {
        driver.get("http://localhost:3000/");
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(), 'SIGN IN')]")));
        WebElement login = driver.findElement(By.xpath("//strong[contains(text(), 'SIGN IN')]"));
        login.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        email.sendKeys("admin2@example.com");
        pass.sendKeys("hunter2"); //would be ENV in any real application
        loginButton.click();

    }
    @When("the user clicks on EDIT PRODUCTS")
    public void the_user_clicks_on_edit_products() {
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[contains(text(),'EDIT PRODUCTS')]")));
        WebElement editProducts = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[1]/strong"));
        editProducts.click();
    }
    @When("the user clicks on CREATE NEW PRODUCT")
    public void the_user_clicks_on_create_new_product() {
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/button")));
        WebElement createProduct = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button"));
        createProduct.click();
    }
    @When("the user types {string} into Product Name input")
    public void the_user_types_into_product_name_input(String string) {
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/input")));
        WebElement productName = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div/input"));
        productName.sendKeys(string);
    }
    @When("the user types {string} into Product Description input")
    public void the_user_types_into_product_description_input(String string) {
        WebElement productDesc = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/div/input"));
        productDesc.sendKeys(string);
    }
    @When("the user types {string} into Image URL")
    public void the_user_types_into_image_url(String string) {
        WebElement imageUrl = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[4]/div/input"));
        imageUrl.sendKeys(string);
    }
    @When("the user types {string} into Product Price input")
    public void the_user_types_into_product_price_input(String string) {
        WebElement price = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[5]/div/input"));
        price.sendKeys(string);
    }
    @When("the user clicks the Create Product button")
    public void the_user_clicks_the_create_product_button() {
        WebElement create = driver.findElement(By.xpath("//button[contains(text(),'create product')]"));
        create.click();
    }


    @When("the user clicks on the Diploma product")
    public void theUserClicksOnTheDiplomaProduct() {
        WebElement diploma = driver.findElement(By.xpath("//h5[contains(text(),'Diploma')]"));
        diploma.click(); //id=":r7:"
    }

    @Then("the new product should be visible on the Products page")
    public void theNewProductShouldBeVisibleOnTheProductsPage() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/h3")));
        WebElement productListing = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/h3"));
        Assertions.assertEquals("Diploma",productListing.getText());
    }

    @When("the user clears the Product Price input")
    public void theUserClearsTheProductPriceInput() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/input")));
        WebElement price = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/input"));
        price.clear();
    }

    @When("the user clicks the UPDATE button")
    public void theUserClicksTheUPDATEButton() {
        WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[3]/button[1]"));
        updateButton.click();
        
    }

    @Then("the product should update with the new price")
    public void theProductShouldUpdateWithTheNewPrice() {
        WebElement backToProducts = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/button"));
        backToProducts.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'Diploma')]")));
        WebElement productListing = driver.findElement(By.xpath("//h5[contains(text(),'Diploma')]"));
        productListing.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4")));
        WebElement price = driver.findElement(By.xpath("//h4"));
        Assertions.assertEquals("$99.99",price.getText());
    }
    

    @When("the user clears all input fields")
    public void theUserClearsAllInputFields() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[1]/div/input")));
        WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[1]/div/input"));
        name.clear();
        WebElement price = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/input"));
        price.clear();
        WebElement imageUrl = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[2]/div/input"));
        imageUrl.clear();
        WebElement productDesc = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[3]/div/input"));
        productDesc.clear();
    }

    @Then("the product should fail to update")
    public void theProductShouldFailToUpdate() {

        WebElement price = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/h4"));
        new WebDriverWait(driver,3).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(price, "$99.99.00")));
        Assertions.assertEquals("$99.99",price.getText());

    }

    @When("the user clicks the DELETE button")
    public void theUserClicksTheDELETEButton() {
        WebElement delete = driver.findElement(By.xpath("//button[last()]"));
        delete.click();
    }

    @Then("the product should no longer be visible")
    public void theProductShouldNoLongerBeVisible() {
        Assertions.assertEquals(new ArrayList<>(), driver.findElements(By.xpath("//h5[contains(text(),'Diploma')]")));
    }

    @When("the user types {string} into  the edit Product Price input")
    public void theUserTypesIntoTheEditProductPriceInput(String arg0) {
        WebElement editPrice = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[4]/div/input"));
        editPrice.sendKeys(arg0);

    }
}
