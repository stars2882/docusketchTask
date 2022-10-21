package pages;

import commons.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    private final String URL = "http://gmail.com";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement fieldLogin;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement checkLogin;

    @FindBy(xpath = "//div[@class='o6cuMc']")
    private WebElement errorMassageLogin;

    @FindBy(xpath = "//div[@class='OyEIQ uSvLId']")
    private WebElement getErrorMassagePass;
    public void openPage() {
        driver.get(URL);
    }

    public void enterLogin(String keyword) {
        waitVisibilityOfElement(200, fieldLogin);
        fieldLogin.sendKeys(keyword, Keys.ENTER);
    }

    public void enterPassword(String keyword) {
        waitVisibilityOfElement(200, fieldPassword);
        fieldPassword.sendKeys(keyword, Keys.ENTER);
    }

    public boolean loginVerification() {
        waitVisibilityOfElement(200, checkLogin);
        return checkLogin.isDisplayed();
    }

    public boolean checkMassageErrorLogin() {
        waitVisibilityOfElement(50,errorMassageLogin);
        return errorMassageLogin.isDisplayed();
    }
    public boolean checkMassageErrorPass() {
        waitVisibilityOfElement(50,getErrorMassagePass);
        return getErrorMassagePass.isDisplayed();
    }
}
