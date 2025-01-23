package pageObjects.nopCommerce.Practice;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.Practice.PracticeRegisterPageUI;

public class PracticeRegisterPageObject extends BasePage {
    WebDriver driver;
    public PracticeRegisterPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void inputFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, PracticeRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,PracticeRegisterPageUI.FIRSTNAME_TEXTBOX,firstname);
    }

    public void inputLastNameTextbox(String lastname) {
        waitForElementVisible(driver,PracticeRegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,PracticeRegisterPageUI.LASTNAME_TEXTBOX,lastname);
    }

    public void inputEmailTextbox(String email) {
        waitForElementVisible(driver,PracticeRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,PracticeRegisterPageUI.EMAIL_TEXTBOX,email);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver,PracticeRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,PracticeRegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void inputConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver,PracticeRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,PracticeRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,password);
    }

    public void clickRegisterButton() {
        waitForElementClickable(driver,PracticeRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,PracticeRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,PracticeRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,PracticeRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public void clickLogOutButton() {
        waitForElementClickable(driver,PracticeRegisterPageUI.LOGOUT_LINK);
        clickToElement(driver,PracticeRegisterPageUI.LOGOUT_LINK);
    }
}
