package com.nopcommerce.users;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.build.Plugin;
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
@Feature("User")
public class Level_16_AllureReport extends BaseTest {
    String browserName;
    private String userUrlValue, adminUrlValue;

    public Level_16_AllureReport() {
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

    @Description("Register to application")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC_01_Register() {



        registerPage = homePage.openRegisterPage();


        registerPage.enterToFirstNameTextbox(firstName);


        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(emailAddress);


        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox (password);


        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completed");
    }

    @Description("Login to application")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void TC_02_Login() {

        homePage = registerPage.clickToLogOutLink();
        //Cho phần khởi tạo loginPage vào phần hàm clickToLoginLink
        loginPage = homePage.openLoginPage();
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        //Từ login về homepage thì cho hàm khở tạo Homepage vào trong hàm click to LoginButton.
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Description("Verify My Account")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_03_MyAccount() {
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @Test
    public void TC_04_Dynamic_Page() {


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
