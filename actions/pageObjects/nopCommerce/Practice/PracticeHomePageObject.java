package pageObjects.nopCommerce.Practice;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Practice.PracticeHomePageUI;

public class PracticeHomePageObject extends BasePage {
    WebDriver driver;
    public PracticeHomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToRegisterLink() {
        waitForElementClickable(driver, PracticeHomePageUI.REGISTER_LINK);
        clickToElement(driver,PracticeHomePageUI.REGISTER_LINK);
    }

    public void clickLoginLink() {
        waitForElementClickable(driver,PracticeHomePageUI.LOGIN_LINK);
        clickToElement(driver,PracticeHomePageUI.LOGIN_LINK);
    }

    public void clickMyAccountLink() {
        waitForElementClickable(driver,PracticeHomePageUI.ACCOUNT_LINK);
        clickToElement(driver,PracticeHomePageUI.LOGIN_LINK);
    }
}
