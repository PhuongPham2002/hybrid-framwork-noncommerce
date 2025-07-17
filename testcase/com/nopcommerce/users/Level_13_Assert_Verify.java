package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;

public class Level_13_Assert_Verify extends BaseTest {
    private String userUrlValue, adminUrlValue;

    public Level_13_Assert_Verify() {
        super();
    }

    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        driver = getBrowserDriver(browserName,userUrlValue);
        firstName ="Davidson";
        lastName="Duthie";
        companyName="Skalith";
        password="wG8#`21)1t{";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        homePage = PageGenerator.getUserHomePage(driver);
    }
    @Test
    public void TC_01_Register() {

        registerPage = homePage.openRegisterPage();
        //Assert 01 - FAILED
        //Assert.assertEquals(registerPage.getRegisterPageTitle(),"Registers");
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox (password);
        registerPage.clickToRegisterButton();
        //Assert 02
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completed");
        homePage = registerPage.clickToLogOutLink();
    }
    @Test
    public void TC_02_Login() {

        //Cho phần khởi tạo loginPage vào phần hàm clickToLoginLink
        loginPage = homePage.openLoginPage();
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        //Từ login về homepage thì cho hàm khở tạo Homepage vào trong hàm click to LoginButton.
        homePage = loginPage.clickToLoginButton();
        customerPage = homePage.openCustomerInfoPage();

    }

    @Test
    public void TC_03_MyAccount() {
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @Test
    public void TC_04_Dynamic_Page() {

       addressPage = (UserAddressPO) customerPage.openSidebarLinkByPageName(driver,"Address");
        rewardPointPage = (UserRewardPointPO) addressPage.openSidebarLinkByPageName(driver,"Reward points");

        //Reward Point --> Order
        orderPage = (UserOrderPO) rewardPointPage.openSidebarLinkByPageName(driver,"Orders");

        //Order --> Address
        addressPage = (UserAddressPO) orderPage.openSidebarLinkByPageName(driver,"Address");

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
