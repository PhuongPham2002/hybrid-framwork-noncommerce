package com.nopcommerce.users;
import com.nopcommerce.common.Login;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.Users.*;

public class Level_21_Browser_Config extends BaseTest {
    String browserName;
    private String userUrlValue;

    public Level_21_Browser_Config() {
        super();
    }

    @Parameters({"userUrl","browser"})
    @BeforeClass
    public void beforeClass(String userUrl,String browserName) {
        userUrlValue = userUrl;
        this.browserName = browserName;
        driver = getBrowserDriver(userUrl,browserName);}

    @Test
    public void User_01_MyAccount() {


    }

    @Test
    public void User_02_Order() {


    }

    @Test
    public void User_03_Payment() {

    }


    @AfterClass (alwaysRun = true)
    public void afterClass() {
        //closeBrowserDriver();
    }

    private WebDriver driver;




}
