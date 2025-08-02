package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import io.cucumber.java.en.*;
import junit.framework.Assert;

import java.time.Duration;

public class Steps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeAdButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='dialog']//button[contains(text(),'Close')]")
            ));
            closeAdButton.click();
            System.out.println("Ad popup closed successfully.");
        } catch (TimeoutException e) {
            System.out.println("Ad popup not displayed, proceeding...");
        }
    }

    @When("User clicks on Create an Account link")
    public void user_clicks_on_create_account_link() {
        WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an Account")));
        createAccountLink.click();
    }

    @When("User enters FirstName as {string} and LastName as {string} and Email as {string} and Password as {string} and ConfirmPassword as {string}")
    public void user_enters_details(String fname, String lname, String email, String pwd, String cpwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys(fname);
        driver.findElement(By.id("lastname")).sendKeys(lname);
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.id("password-confirmation")).sendKeys(cpwd);
    }

    @When("User clicks on Create an Account button")
    public void user_clicks_on_create_account_button() {
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title to be '" + expectedTitle + "' but was: " + actualTitle);
        }
    }

    @And("User waits for 2 seconds")
    public void user_waits_for_seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-action='customer-menu-toggle']")));
    }


    @Then("User clicks on Sign out link")
    public void user_clicks_on_sign_out_link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Wait for and click the customer menu toggle (user icon)
            WebElement menuToggle = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[data-action='customer-menu-toggle']")));
            menuToggle.click();

            // Wait for and click the Sign Out link that appears in dropdown
            WebElement signOutLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a[href*='customer/account/logout/']")));
            signOutLink.click();

        } catch (TimeoutException e) {
            System.out.println("Timeout while waiting for Sign Out: " + e.getMessage());
            throw e;
        }
    }




    @Then("User should see logout confirmation message")
    public void user_should_see_logout_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success")));
    }

    @And("Close the browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
