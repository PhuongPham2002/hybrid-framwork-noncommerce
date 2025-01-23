package pageObjects.nopCommerce.Admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.Admin.AdminLoginUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminDashboardPO clickLoginButton() {
        waitForElementClickable(driver,AdminLoginUI.LOGIN_BUTTON);
        clickToElement(driver,AdminLoginUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }

    public void enterPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,AdminLoginUI.PASSWORD_TEXTBOX,password);
    }

    public void enterUsernameTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver,AdminLoginUI.EMAIL_TEXTBOX,emailAddress);
    }
}
