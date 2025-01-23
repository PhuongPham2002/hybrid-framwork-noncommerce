package pageFactory.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage{
    private WebDriver driver;
    public LoginPageFactory (WebDriver driver){
        driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH, using = "//input[@name ='username']")
    private WebElement usernameTextbox;

    @CacheLookup
    @FindBy(xpath = "//input[@name ='password']")
    private WebElement passwordTextbox;
    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginButton;

    public void enterUsernameTextbox(String username) {
        waitForElementVisible(driver, usernameTextbox);
        sendKeyToElement(usernameTextbox,username);
    }

    public void enterPassword(String password) {
        waitForElementVisible(driver,passwordTextbox);
        sendKeyToElement(passwordTextbox,password);
    }

    public void clickLoginButton() {
        waitForElementClickable(driver,loginButton);
        clickElement(loginButton);

    }
}
