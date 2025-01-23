package pageObjects.nopCommerce.Practice;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Practice.PracticeLoginPageUI;

public class PracticeLoginPageObject extends BasePage {
    WebDriver driver;
    public PracticeLoginPageObject (WebDriver driver){
        this.driver = driver;

    }
    public void inputEmailTextbox(String email) {
        waitForElementVisible(driver, PracticeLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,PracticeLoginPageUI.EMAIL_TEXTBOX,email);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, PracticeLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,PracticeLoginPageUI.EMAIL_TEXTBOX,password);
    }

    public void clickLoginButton() {
        waitForElementClickable(driver,PracticeLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,PracticeLoginPageUI.LOGIN_BUTTON);
    }
}
