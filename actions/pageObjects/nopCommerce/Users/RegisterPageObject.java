package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.Users.UserRegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter FirstName Textbox with value: {0}") //{0} là index cho biến đầu tiên
    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX,firstName);

    }

    @Step("Enter Lastname Textbox with value: {0}")
    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX,lastName);
    }

    @Step("Enter Email Textbox with value: {0}")
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,email);
        
    }

    @Step("Enter Password Textbox with value: {0}")
    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Enter Email Password with value: {0}")
    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    @Step("Click Register Button")
    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    @Step("Show Register Successful Message")
    public String getRegisterSuccessfulMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Click Logout Button")
    public UserHomePO clickToLogOutLink() {
        waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        clickToElement(driver, UserRegisterPageUI.LOGOUT_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }


    @Step("Show Register Page Title")
    public String getRegisterPageTitle() {
        waitForElementVisible(driver,UserRegisterPageUI.REGISTER_PAGE_TITLE);
        return getElementText(driver,UserRegisterPageUI.REGISTER_PAGE_TITLE);
    }
}
