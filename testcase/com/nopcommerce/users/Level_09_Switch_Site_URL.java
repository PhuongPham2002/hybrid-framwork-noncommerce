package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Admin.AdminDashboardPO;
import pageObjects.nopCommerce.Admin.AdminLoginPO;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;

public class Level_09_Switch_Site_URL extends BaseTest {
    private String userUrlValue, adminUrlValue;
    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        driver = getBrowserDriver(browserName,userUrlValue);
        //basePage = new BasePage();
        firstName ="Davidson";
        lastName="Duthie";
        companyName="Skalith";
        password="wG8#`21)1t{";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        adminEmail = "admin@yourstore.com";
        adminPassword = "admin";
        userHomePage = PageGenerator.getUserHomePage(driver);

        //Pre-condition:

        userRegisterPage = userHomePage.openRegisterPage();
        userRegisterPage.enterToFirstNameTextbox(firstName);
        userRegisterPage.enterToLastNameTextbox(lastName);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox (password);
        userRegisterPage.clickToRegisterButton();
        Assert.assertEquals(userRegisterPage.getRegisterSuccessfulMessage(),"Your registration completed");
        userHomePage = userRegisterPage.clickToLogOutLink();
    }
    @Test
    public void Role_01_UserSite_to_AdminSite() {

        //Cho phần khởi tạo loginPage vào phần hàm clickToLoginLink
        userLoginPage = userHomePage.openLoginPage();
        userLoginPage.enterToEmailTextbox(emailAddress);
        userLoginPage.enterToPasswordTextbox(password);
        //Từ login về homepage thì cho hàm khở tạo Homepage vào trong hàm click to LoginButton.
        userHomePage = userLoginPage.clickToLoginButton();
        //Step để order 1 product nào đó
        //Qua trang admin để verify/approve cái order ở trên với quyền admin
        userHomePage.openPageUrl(driver,adminUrlValue);
        adminLoginPage=PageGenerator.getAdminLoginPage(driver);
        //Login vào trang admin
        adminLoginPage.enterUsernameTextbox(adminEmail);
        adminLoginPage.enterPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickLoginButton();
        //Vào trang Dashboard
    }

    @Test
    public void Role_02_AdminSite_to_UserSite() {
        // Vaof trang order/customer....
        adminDashboardPage.openPageUrl(driver,userUrlValue);
        userHomePage = PageGenerator.getUserHomePage(driver);
        customerPage = userHomePage.openCustomerInfoPage();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String emailAddress;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private RegisterPageObject userRegisterPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;

    private UserCustomerInforPO customerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    String firstName, lastName,companyName,password;
    String adminEmail, adminPassword;



}
