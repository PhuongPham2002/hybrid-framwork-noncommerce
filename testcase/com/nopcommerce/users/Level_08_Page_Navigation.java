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

public class Level_08_Page_Navigation extends BaseTest {
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
        //basePage = new BasePage();
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
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox (password);
        registerPage.clickToRegisterButton();
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

    }

    @Test
    public void TC_03_MyAccount() {
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @Test
    public void TC_04_SwitchPage() {
        //Customer Info --> Address
        addressPage = customerPage.openAddressPage(driver);
        //Add new address
        //....

        //Address --> Reward Point
        rewardPointPage = addressPage.openRewardPointPage(driver);
        // thực thi một số hành động tại trnag reward.

        //Reward Point --> Order
        orderPage = rewardPointPage.openOrderPage(driver);
        //....

        //Order --> Address
        addressPage = orderPage.openAddressPage(driver);

        //Address --> Customer Info
        customerPage = addressPage.openCustomerInfoPage(driver);

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
