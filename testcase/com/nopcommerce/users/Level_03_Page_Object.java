package com.nopcommerce.users;
/**

 */

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Users.UserCustomerInforPO;
import pageObjects.nopCommerce.Users.UserHomePO;
import pageObjects.nopCommerce.Users.UserLoginPO;
import pageObjects.nopCommerce.Users.RegisterPageObject;

import java.time.Duration;

public class Level_03_Page_Object extends BaseTest {

    public Level_03_Page_Object() {
        super();
    }

    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/hosyh/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 1");
        driver = new EdgeDriver(edgeOptions);
        //basePage = new BasePage();
        firstName ="Davidson";
        lastName="Duthie";
        companyName="Skalith";
        password="wG8#`21)1t{";
        emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
        driver.get("https://demo.nopcommerce.com/");
        homePage = new UserHomePO(driver);


    }
    @Test
    public void TC_01_Register() {
        homePage.openRegisterPage();
        registerPage = new RegisterPageObject(driver);
        registerPage.enterToFirstNameTextbox(firstName);
        registerPage.enterToLastNameTextbox(lastName);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox (password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completed");
        registerPage.clickToLogOutLink();
        // Click LogOut về lại trang Home
        //Register page  --> home page
        homePage = new UserHomePO(driver);
    }
    @Test
    public void TC_02_Login() {
        homePage.openLoginPage();
        //Tu page home qua page Login
        loginPage = new UserLoginPO(driver);
        loginPage.enterToEmailTextbox(emailAddress);
        loginPage.enterToPasswordTextbox(password);
        loginPage.clickToLoginButton();
        //Tu login ve Home
        homePage = new UserHomePO(driver);

    }

    @Test
    public void TC_03_MyAccount() {
        homePage.openCustomerInfoPage();
        customerPage = new UserCustomerInforPO(driver);
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    WebDriver driver;
    String emailAddress;
    UserHomePO homePage;
    UserLoginPO loginPage;
    RegisterPageObject registerPage;
    UserCustomerInforPO customerPage;
    String firstName, lastName,companyName,password;



}
