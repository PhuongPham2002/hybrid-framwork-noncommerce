package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Users.UserCustomerInforPO;
import pageObjects.nopCommerce.Users.UserHomePO;
import pageObjects.nopCommerce.Users.UserLoginPO;
import pageObjects.nopCommerce.Users.RegisterPageObject;

public class Level_06_Page_Generator_01 extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName,url);
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
        homePage = new UserHomePO(driver);
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
    String firstName, lastName,companyName,password;



}
