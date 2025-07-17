package com.nopcommerce.users;
import com.nopcommerce.common.Login;
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

public class Level_20_Share_State extends BaseTest {
    String browserName;
    private String userUrlValue, adminUrlValue;

    public Level_20_Share_State() {
        super();
    }

    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        this.browserName = browserName;
        driver = getBrowserDriver(browserName,userUrlValue);
        homePage = PageGenerator.getUserHomePage(driver);
        // Pre-condition: Login by cookie
        homePage.setCookies(driver,Login.nopCommerceCookies);
        homePage.refreshPage(driver);
        Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
    }

    @Test
    public void User_01_MyAccount() {
        customerPage = homePage.openCustomerInfoPage();
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"FirstName"),Login.firstName);
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"LastName"),Login.lastName);
        Assert.assertEquals(customerPage.getTexboxValueByID(driver,"Email"),Login.emailAddress);

    }

    @Test
    public void User_02_Order() {


    }

    @Test
    public void User_03_Payment() {

    }


    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
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
