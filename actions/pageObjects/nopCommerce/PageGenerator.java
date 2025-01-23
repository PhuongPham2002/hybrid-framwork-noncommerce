package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.Admin.AdminDashboardPO;
import pageObjects.nopCommerce.Admin.AdminLoginPO;
import pageObjects.nopCommerce.Users.*;

public class PageGenerator {
    public static UserHomePO getUserHomePage(WebDriver driver){
        return new UserHomePO(driver);
    }
    public static UserLoginPO getUserLoginPage(WebDriver driver){
        return new UserLoginPO(driver);
    }
    public static RegisterPageObject getUserRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }
    public static UserCustomerInforPO getUserCustomerPage(WebDriver driver){
        return new UserCustomerInforPO(driver);
    }
    public static UserAddressPO getUserAddressPage(WebDriver driver){
        return new UserAddressPO(driver);
    }
    public static UserOrderPO getUserOrderPage(WebDriver driver){
        return new UserOrderPO(driver);
    }
    public static UserRewardPointPO getUserRewardPointPage(WebDriver driver){
        return new UserRewardPointPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver){
        return new AdminDashboardPO(driver);
    }
    public static AdminLoginPO getAdminLoginPage(WebDriver driver){
        return new AdminLoginPO(driver);
    }

}
