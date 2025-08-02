package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    public WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    By lnkCreateAccount = By.linkText("Create an Account");
    By txtFirstName = By.id("firstname");
    By txtLastName = By.id("lastname");
    By txtEmail = By.id("email_address");
    By txtPassword = By.id("password");
    By txtConfirmPassword = By.id("password-confirmation");
    By btnCreateAccount = By.cssSelector("button[title='Create an Account']");

    public void clickCreateAccountLink() {
        driver.findElement(lnkCreateAccount).click();
    }

    public void setFirstName(String fname) {
        driver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname) {
        driver.findElement(txtLastName).sendKeys(lname);
    }

    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }

    public void setConfirmPassword(String cpwd) {
        driver.findElement(txtConfirmPassword).sendKeys(cpwd);
    }

    public void clickCreateAccount() {
        driver.findElement(btnCreateAccount).click();
    }
}
