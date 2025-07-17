package com.nopcommerce.users;
import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;
import ultilities.ExcelConfig;

@Feature("User")
public class Level_26_Manage_Date_06_Excel extends BaseTest {
    String browserName;
    private String userUrlValue, adminUrlValue;
    private ExcelConfig excelConfig;

    public Level_26_Manage_Date_06_Excel() {
        super();
    }

    @Parameters({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        userUrlValue = userUrl;
        this.browserName = browserName;
        driver = getBrowserDriver(browserName,userUrlValue);
        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("Employee");
        emailAddress = excelConfig.getCellData("EmailAddress",1)+generateFakeNumber()+"@mail.vn";
        firstName =excelConfig.getCellData("Firstname",1);
        lastName=excelConfig.getCellData("Firstname",1);
        companyName=excelConfig.getCellData("Company",1);
        password=excelConfig.getCellData("Password",1);
        homePage = PageGenerator.getUserHomePage(driver);
    }

    @Test
    public void TC_01_Register() {

        registerPage = homePage.openRegisterPage();
        registerPage.enterTextboxByID(driver,"FirstName", firstName);
        registerPage.enterTextboxByID(driver,"LastName", lastName);
        registerPage.enterTextboxByID(driver,"Email",emailAddress);
        registerPage.enterTextboxByID(driver,"Password",password);
        registerPage.enterTextboxByID(driver,"ConfirmPassword",password);
        registerPage.clickButtonText(driver,"Register");
        Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {


        homePage = registerPage.clickToLogOutLink();
        //Cho phần khởi tạo loginPage vào phần hàm clickToLoginLink
        loginPage = homePage.openLoginPage();
        loginPage.enterTextboxByID(driver,"Email",emailAddress);
        loginPage.enterTextboxByID(driver,"Password",password);
        //Từ login về homepage thì cho hàm khở tạo Homepage vào trong hàm click to LoginButton.
        loginPage.clickButtonText(driver,"Log in");
        homePage = PageGenerator.getUserHomePage(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

    }

    @Description("Verify My Account")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_03_MyAccount() {
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"FirstName"),firstName);
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"LastName"),lastName);
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"Email"),emailAddress);
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
