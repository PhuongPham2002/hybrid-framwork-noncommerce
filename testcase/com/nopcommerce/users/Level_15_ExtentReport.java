package com.nopcommerce.users;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;
import reportConfig.ExtentManager;

import java.lang.reflect.Method;

public class Level_15_ExtentReport extends BaseTest {
    String browserName;
    private String userUrlValue, adminUrlValue;

    public Level_15_ExtentReport() {
        super();
    }

    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        this.browserName = browserName;
        driver = getBrowserDriver(browserName,userUrlValue);
        firstName ="Davidson";
        lastName="Duthie";
        companyName="Skalith";
        password="wG8#`21)1t{";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        homePage = PageGenerator.getUserHomePage(driver);
    }
    @Test
    public void TC_01_Register(Method method) {

        ExtentManager.startTest(method.getName() +"-" + browserName, "TC_01_Register");
        ExtentManager.getTest().log(Status.INFO, "NewCustomer - Step 01: Open 'New Customer' page");

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 01: Open Register page");

        registerPage = homePage.openRegisterPage();

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 02: Enter firstName textbox with value: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 03: Enter lastname textbox with value: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);
        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 04: Enter emailAddress textbox with value: " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 05: Enter password textbox with value: " + password);
        registerPage.enterToPasswordTextbox(password);
        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 06: Enter password textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextbox (password);

        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 07: click register button");
        registerPage.clickToRegisterButton();
        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 08: Verify success message: Your registration completed");
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completeddd");
    }
    @Test
    public void TC_02_Login(Method method) {
        ExtentManager.startTest(method.getName() +"-" + browserName, "TC_02_Login");
        ExtentManager.getTest().log(Status.INFO,"TC_01_Register - STEP 07: click logout link");
        homePage = registerPage.clickToLogOutLink();
        //Cho phần khởi tạo loginPage vào phần hàm clickToLoginLink
        loginPage = homePage.openLoginPage();
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        //Từ login về homepage thì cho hàm khở tạo Homepage vào trong hàm click to LoginButton.
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Test
    public void TC_03_MyAccount(Method method) {
        ExtentManager.startTest(method.getName() +"-" + browserName, "TC_03_MyAccount");
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @Test
    public void TC_04_Dynamic_Page(Method method) {
        ExtentManager.startTest(method.getName() +"-" + browserName, "TC_04_Dynamic_Page");

       addressPage = (UserAddressPO) customerPage.openSidebarLinkByPageName(driver,"Addresses");
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName(driver,"Reward points");

        //Reward Point --> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName(driver,"Orders");

        //Order --> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName(driver,"Addresses");

        //Address --> Customer Info
        customerPage = (UserCustomerInforPO) addressPage.openSidebarLinkByPageName(driver,"Customer info");

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String emailAddress;
    private UserHomePO homePage;
    private UserLoginPO loginPage;
    private RegisterPageObject registerPage;

    private UserCustomerInforPO customerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    String firstName, lastName,companyName,password;



}
