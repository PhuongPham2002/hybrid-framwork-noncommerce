package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenerator;

public class Level_12_Upload extends BaseTest {
    private String url, adminUrlValue;

    public Level_12_Upload() {
        super();
    }

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        this.url = url;
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        haLong ="Ha Long.jpg";
        haNoi ="Ha Noi.jpg";
        hcm = "HCM.jpg";
    }
    @Test
    public void Upload_01() {
        // Lấy ra được đường dẫn của file thư mục cho đúng
        // Tất cả các OS: Window, MAC, Linux đều phải chạy được
        // Có thể upload 1 lần 1 file => dùng 1 hàm
        homePage.uploadMultipleFiles(driver,haLong);
        homePage.sleepInSecond(3);
        homePage.refreshPage(driver);

        // có thể upload 1 lần nhiều file => dùng 1 hàm
        homePage.uploadMultipleFiles(driver,haLong,haNoi);
        homePage.sleepInSecond(3);
        homePage.refreshPage(driver);

        homePage.uploadMultipleFiles(driver,haLong,haNoi,hcm);
        homePage.sleepInSecond(3);

        // Verify việc load file
        Assert.assertTrue(homePage.isFileLoadedByName(haNoi));
        Assert.assertTrue(homePage.isFileLoadedByName(haLong));
        Assert.assertTrue(homePage.isFileLoadedByName(hcm));

        //Click upload button tại từng file
        homePage.clickUploadButton(driver);

        // Có thể verify => dùng 1 hàm cho 1 và nhiều files được upload xong.
        Assert.assertTrue(homePage.isFileUploadedByName(haNoi));
        Assert.assertTrue(homePage.isFileUploadedByName(hcm));
        Assert.assertTrue(homePage.isFileUploadedByName(haLong));

        //Có cần care tới open File Diaglog hay không? (cửa window chọn file)  -> không cần care vì cách đang làm ko cần đụng tới open file diaglog.

    }
    @Test
    public void Upload_Multiple() {
        //Enter value to header textbox


    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private String haLong, haNoi,hcm;




}
