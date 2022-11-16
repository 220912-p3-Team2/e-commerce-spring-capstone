package com.revature.steps;

import com.revature.Runner.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.validation.constraints.AssertTrue;
import java.time.Duration;

public class ProductDetailViewSteps {

    WebDriver driver = Runner.driver;
    WebDriverWait wait = new WebDriverWait(driver,10);
    Actions action = new Actions(driver);

    private String xpathModal = "/html/body/div[@class='MuiDialog-root MuiModal-root css-153eyq5-MuiModal-root-MuiDialog-root']/div[@class='MuiDialog-container MuiDialog-scrollBody css-iz3z40-MuiDialog-container']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollBody MuiDialog-paperWidthSm css-2zwj5t-MuiPaper-root-MuiDialog-paper']";
    private String xpathTitle = "/html/body/div[@class='MuiDialog-root MuiModal-root css-153eyq5-MuiModal-root-MuiDialog-root']/div[@class='MuiDialog-container MuiDialog-scrollBody css-iz3z40-MuiDialog-container']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollBody MuiDialog-paperWidthSm css-2zwj5t-MuiPaper-root-MuiDialog-paper']/h2[@id='customized-dialog-title']";
    private String xpathImage = "/html/body/div[@class='MuiDialog-root MuiModal-root css-153eyq5-MuiModal-root-MuiDialog-root']/div[@class='MuiDialog-container MuiDialog-scrollBody css-iz3z40-MuiDialog-container']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollBody MuiDialog-paperWidthSm css-2zwj5t-MuiPaper-root-MuiDialog-paper']/div[@class='MuiDialogContent-root MuiDialogContent-dividers css-1t4vnk2-MuiDialogContent-root'][1]/img[@class='sc-ikZpkk ijsMvo']/@src";
    private String xpathPrice = "/html/body/div[@class='MuiDialog-root MuiModal-root css-153eyq5-MuiModal-root-MuiDialog-root']/div[@class='MuiDialog-container MuiDialog-scrollBody css-iz3z40-MuiDialog-container']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollBody MuiDialog-paperWidthSm css-2zwj5t-MuiPaper-root-MuiDialog-paper']/div[@class='MuiDialogContent-root MuiDialogContent-dividers css-1t4vnk2-MuiDialogContent-root'][2]/p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom css-d3wcwz-MuiTypography-root']";
    private String xpathDesc = "/html/body/div[@class='MuiDialog-root MuiModal-root css-153eyq5-MuiModal-root-MuiDialog-root']/div[@class='MuiDialog-container MuiDialog-scrollBody css-iz3z40-MuiDialog-container']/div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollBody MuiDialog-paperWidthSm css-2zwj5t-MuiPaper-root-MuiDialog-paper']/div[@class='MuiDialogContent-root MuiDialogContent-dividers css-1t4vnk2-MuiDialogContent-root'][3]/p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-gutterBottom css-d3wcwz-MuiTypography-root']";
    @Given("The user is on the main page")
    public void the_user_is_on_the_main_page() {
        driver.get("http://localhost:3000");


    }
    @When("the user clicks on a product details button")
    public void the_user_clicks_on_a_product_details_button() {
        WebElement detialsBtn = driver.findElement(By.xpath("//div/svg"));
        action.moveToElement(detialsBtn).pause(Duration.ofSeconds(1)).click();
    }
    @Then("the user should see an image, price, description, and reviews")
    public void the_user_should_see_an_image_price_description_and_reviews() {
        WebElement title = driver.findElement(By.xpath(xpathTitle));
        WebElement image = driver.findElement(By.xpath(xpathImage));
        WebElement price = driver.findElement(By.xpath(xpathPrice));
        WebElement desc = driver.findElement(By.xpath(xpathDesc));

        boolean pass = false;

        WebElement[] elms = {title, image, price, desc};
        for(int i = 0; i < elms.length; i++){
            Assert.assertNull(elms[i]);
        }

    }

}
