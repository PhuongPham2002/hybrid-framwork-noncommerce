package pageObjects.nopCommerce.Users;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Users.UserCustomerPageUI;

public class UserCustomerInforPO extends UserSidebarBasePage {
    private WebDriver driver;

    public UserCustomerInforPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get Firstname Textbox value")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.FIRSTNAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerPageUI.FIRSTNAME_TEXTBOX,"value");

    }

    @Step("Get Lastname Textbox value")
    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.LASTNAME_TEXTBOX);
        return getAttributeValue(driver, UserCustomerPageUI.LASTNAME_TEXTBOX,"value");
    }

    @Step("Get Email Textbox value")
    public String getEmailTextboxValue() {
        waitForElementVisible(driver, UserCustomerPageUI.EMAIL_TEXTBOX);
        return getAttributeValue(driver, UserCustomerPageUI.EMAIL_TEXTBOX,"value");
    }

}
