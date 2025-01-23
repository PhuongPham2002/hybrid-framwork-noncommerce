package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.Practice.PracticeCustomerInforPageObject;
import pageObjects.nopCommerce.Practice.PracticeHomePageObject;
import pageObjects.nopCommerce.Practice.PracticeLoginPageObject;
import pageObjects.nopCommerce.Practice.PracticeRegisterPageObject;

import java.util.Random;

public class Page_Object_Practice extends BaseTest {
    WebDriver driver;
    Random rand;
    PracticeHomePageObject homePage;
    PracticeRegisterPageObject registerPage;
    PracticeLoginPageObject loginPage;
    PracticeCustomerInforPageObject customerPage;
    String firstName, lastName, emailAddress, password;

    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/hosyh/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 1");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/");
        homePage = new PracticeHomePageObject(driver);
        firstName ="Hagan";
        lastName ="Ashe";
        emailAddress = "testVn" + generateRandomNumber()+ "@gmail.com";
        password ="rY7@'O~?QLE2g$";
    }

    @Test

    public void TC_01_Register() {
        homePage.clickToRegisterLink();
        registerPage = new PracticeRegisterPageObject(driver);
        registerPage.inputFirstNameTextbox(firstName);
        registerPage.inputLastNameTextbox (lastName);
        registerPage.inputEmailTextbox(emailAddress);
        registerPage.inputPasswordTextbox(password);
        registerPage.inputConfirmPasswordTextbox(password);
        registerPage.clickRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
        registerPage.clickLogOutButton();
        homePage = new PracticeHomePageObject(driver);

    }
    @Test
    public void TC_02_Login() {
        homePage.clickLoginLink();
        loginPage = new PracticeLoginPageObject(driver);
        loginPage.inputEmailTextbox(emailAddress);
        loginPage.inputPasswordTextbox(password);
        loginPage.clickLoginButton();
        homePage = new PracticeHomePageObject(driver);

    }
    @Test
    public void TC_03_MyAccount() {
        homePage.clickMyAccountLink();
        customerPage = new PracticeCustomerInforPageObject(driver);
        Assert.assertEquals(customerPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerPage.getEmailTextboxValue(),emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
