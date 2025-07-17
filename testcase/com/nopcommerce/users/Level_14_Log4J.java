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

public class Level_14_Log4J extends BaseTest {
    private String userUrlValue, adminUrlValue;

    public Level_14_Log4J() {
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

        log.info("TC_01_Register - STEP 01: Open Register page");

        registerPage = homePage.openRegisterPage();

        log.info("TC_01_Register - STEP 02: Enter firstName textbox with value: " + firstName);
        registerPage.enterToFirstNameTextbox(firstName);

        log.info("TC_01_Register - STEP 03: Enter lastname textbox with value: " + lastName);
        registerPage.enterToLastNameTextbox(lastName);
        log.info("TC_01_Register - STEP 04: Enter emailAddress textbox with value: " + emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("TC_01_Register - STEP 05: Enter password textbox with value: " + password);
        registerPage.enterToPasswordTextbox(password);
        log.info("TC_01_Register - STEP 06: Enter password textbox with value: " + password);
        registerPage.enterToConfirmPasswordTextbox (password);

        log.info("TC_01_Register - STEP 07: click register button");
        registerPage.clickToRegisterButton();
        log.info("TC_01_Register - STEP 08: Verify success message: Your registration completed");
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completeddd");
    }
    @Test
    public void TC_02_Login() {
        log.info("TC_01_Register - STEP 07: click logout link");
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
