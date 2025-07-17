package pageObjects.saucelabs;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import saucelabs.LoginPUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public InventoryPageObject loginApplication(String userName, String passWord) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver,LoginPUI.USERNAME_TEXTBOX,userName);
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPUI.PASSWORD_TEXTBOX,passWord);
        waitForElementClickable(driver,LoginPUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPUI.LOGIN_BUTTON);

        return PageGenerator.getInventoryPageObjet(driver);
    }
}
