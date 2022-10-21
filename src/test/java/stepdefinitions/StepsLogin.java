package stepdefinitions;

import commons.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class StepsLogin {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setup() {
        this.driver = DriverFactory.getNewInstance();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @Given("User opens home page")
    public void userOpensHomePageIsSite() {
        loginPage.openPage();
    }

    @And("Enter login {string} in field")
    public void enterLoginLoginInField(String keyword) {
        loginPage.enterLogin(keyword);
    }
    @And("Enter password {string} in field")
    public void enterPasswordPasswordInField(String keyword) {
        loginPage.enterPassword(keyword);
    }
    @After
    public void tearDown(){
        driver.quit();
    }


    @Then("Check we are logged in gmail")
    public void checkWeAreLoggedInGmail() {
        Assert.assertTrue(loginPage.loginVerification());
    }

    @Then("Check for an error message login")
    public void checkForAnErrorMessage() {
        Assert.assertTrue(loginPage.checkMassageErrorLogin());
    }

    @Then("Check for an error message password")
    public void checkForAnErrorMessagePassword() {
        Assert.assertTrue(loginPage.checkMassageErrorPass());
    }
}
