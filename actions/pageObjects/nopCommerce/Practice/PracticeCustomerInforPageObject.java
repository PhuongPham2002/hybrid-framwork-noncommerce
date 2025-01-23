package pageObjects.nopCommerce.Practice;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Practice.PracticeCustomerPageUI;

public class PracticeCustomerInforPageObject extends BasePage {
    WebDriver driver;
    public PracticeCustomerInforPageObject(WebDriver driver){
        this.driver = driver;
    }
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, PracticeCustomerPageUI.FIRSTNAME_TEXTBOX);
        return getElementText(driver,PracticeCustomerPageUI.FIRSTNAME_TEXTBOX);
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, PracticeCustomerPageUI.LASTNAME_TEXTBOX);
        return getElementText(driver,PracticeCustomerPageUI.LASTNAME_TEXTBOX);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, PracticeCustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
        return getElementText(driver,PracticeCustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
    }
}
