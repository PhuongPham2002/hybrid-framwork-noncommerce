package pageObjects.nopCommerce.Users;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Users.UserCustomerPageUI;

public class UserCustomerInforPO extends UserSidebarBasePage {
    private WebDriver driver;

    public UserCustomerInforPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.FIRSTNAME_TEXTBOX);
        return getElementText(driver, UserCustomerPageUI.FIRSTNAME_TEXTBOX);

    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.LASTNAME_TEXTBOX);
        return getElementText(driver, UserCustomerPageUI.LASTNAME_TEXTBOX);
    }

    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.EMAIL_TEXTBOX);
        return getElementText(driver, UserCustomerPageUI.EMAIL_TEXTBOX);
    }

}
