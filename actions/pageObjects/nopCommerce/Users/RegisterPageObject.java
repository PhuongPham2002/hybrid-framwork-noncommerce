package pageObjects.nopCommerce.Users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.Users.UserRegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX,firstName);

    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX,lastName);
    }

    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,email);
        
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessfulMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserHomePO clickToLogOutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }


    public String getRegisterPageTitle() {
        waitForElementVisible(driver,UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver,UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
