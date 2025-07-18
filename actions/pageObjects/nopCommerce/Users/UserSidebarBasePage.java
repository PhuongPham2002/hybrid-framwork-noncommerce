package pageObjects.nopCommerce.Users;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.Users.UserSidebarPageUI;

public class UserSidebarBasePage extends BasePage {

    @Step("Open Reward Point Page")
    public UserRewardPointPO openRewardPointPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINTS_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINTS_LINK);
        return PageGenerator.getUserRewardPointPage(driver);
    }

    @Step("Open Customer Info Page")
    public UserCustomerInforPO openCustomerInfoPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }

    @Step("Open Addresses Page")
    public UserAddressPO openAddressPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }

    @Step("Open Order Page")
    public UserOrderPO openOrderPage(WebDriver driver) {
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    //Phù hợp số lwuongj page ít, còn số lượng page quá nhiều thì dùng cách khác
    public UserSidebarBasePage openSidebarLinkByPageName(WebDriver driver, String pageName){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,pageName);
        clickToElement(driver,UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("Page name is not valid");
        }

    }
}
