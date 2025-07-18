package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.Users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver){
        this.driver=driver;
    }
    @Step("Open Register Page")
    public RegisterPageObject openRegisterPage() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }
    @Step("Open Customer Page")
    public UserCustomerInforPO openCustomerInfoPage() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
    @Step("Open Login Page")
    public UserLoginPO openLoginPage() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    @Step("Show My Account Link")
    public boolean isMyAccountLinkDisplayed() {
       return isElementDisplayed(driver,UserHomePageUI.MY_ACCOUNT_LINK);
    }
}
