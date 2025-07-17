package com.nopcommerce.common;
import commons.BaseTest;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;
import java.util.Set;


public class Login extends BaseTest {
    String browserName;
    private String userUrlValue, adminUrlValue;

    public Login() {
        super();
    }

    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeTest
    public void beforeTest(String browserName, String userUrl, String adminUrl) {

        driver = getBrowserDriver(browserName,userUrl);
        homePage = PageGenerator.getUserHomePage(driver);

        //Data test
        this.browserName = browserName;
        firstName ="Davidson";
        lastName="Duthie";
        companyName="Skalith";
        password="wG8#`21)1t{";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

        //New User
        registerPage = homePage.openRegisterPage();
        registerPage.enterTextboxByID(driver,"FirstName", firstName);
        registerPage.enterTextboxByID(driver,"LastName", lastName);
        registerPage.enterTextboxByID(driver,"Email",emailAddress);
        registerPage.enterTextboxByID(driver,"Password",password);
        registerPage.enterTextboxByID(driver,"ConfirmPassword",password);
        registerPage.clickButtonText(driver,"Register");
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completed");

        //Login
        homePage = registerPage.clickToLogOutLink();
        loginPage = homePage.openLoginPage();
        loginPage.enterTextboxByID(driver,"Email",emailAddress);
        loginPage.enterTextboxByID(driver,"Password",password);
        loginPage.clickButtonText(driver,"Log in");
        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

        //Get cookies
        nopCommerceCookies = homePage.getAllCookies(driver);
        driver.quit();
    }


    private WebDriver driver;
    public static String emailAddress;
    private UserHomePO homePage;
    private UserLoginPO loginPage;
    private RegisterPageObject registerPage;

    private UserCustomerInforPO customerPage;
    private UserAddressPO addressPage;
    private UserOrderPO orderPage;
    private UserRewardPointPO rewardPointPage;

    public static String firstName, lastName,companyName,password;
    public static Set<Cookie> nopCommerceCookies;



}
