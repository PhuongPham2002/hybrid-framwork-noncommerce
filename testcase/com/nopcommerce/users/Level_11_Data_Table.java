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
import pageObjects.nopCommerce.Users.*;

public class Level_11_Data_Table extends BaseTest {
    private String url, adminUrlValue;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        this.url = url;
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
    }
    //@Test
    public void Table_01() {
        // Chuyển trang thành công (chỗ phần paging) --> khi chuyển trang thành công thì sẽ có trang thái active trong thẻ html
        homePage.openPageByNumber("2");
        Assert.assertTrue(homePage.isPageNumberActivated("2"));
        homePage.openPageByNumber("9");
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActivated("15"));



    }
    //@Test
    public void Table_02_Search() {
        //Enter value to header textbox


        homePage.enterTextboxByHeaderName("Country","Algeria");
        homePage.sleepInSecond(4);
        Assert.assertTrue(homePage.isRowDataValueDisplayed("283821","Algeria","295140","578961"));
        homePage.refreshPage(driver);



        homePage.enterTextboxByHeaderName("Females","384187");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187","Afghanistan","407124","791312"));
        homePage.sleepInSecond(2);
        homePage.refreshPage(driver);

        homePage.enterTextboxByHeaderName("Males","407124");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("384187","Afghanistan","407124","791312"));
        homePage.sleepInSecond(2);
        homePage.refreshPage(driver);
        //Verify data in any row

    }

    //@Test
    public void Table_03_Edit_Delete() {
        // Tim ra 1 cái key duy nhất trong table: - key của table để đến các element khác
        //Click Delete button
        homePage.enterTextboxByHeaderName("Country","Algeria");
        homePage.sleepInSecond(4);
        homePage.deleteRowByCountryName("Algeria");
        homePage.refreshPage(driver);

        homePage.enterTextboxByHeaderName("Country","Guatemala");
        homePage.sleepInSecond(4);
        homePage.deleteRowByCountryName("Guatemala");
        homePage.refreshPage(driver);

        //Edit
        homePage.enterTextboxByHeaderName("Country","Albania");
        homePage.sleepInSecond(4);
        homePage.editRowByCountryName("Albania");
        homePage.refreshPage(driver);

        homePage.enterTextboxByHeaderName("Country","Argentina");
        homePage.sleepInSecond(4);
        homePage.editRowByCountryName("Argentina");
        homePage.refreshPage(driver);


    }
    @Test
    public void Table_06_Get_All_Value_Row_Or_Column() {
        homePage.getAllValueInAColumn("Country");

    }
    //@Test
    public void Table_04_Action_By_Index() {
        //Có thể thao tác bất kỳ column và row nào
        homePage.openPageUrl(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/#google_vignette");
        homePage.clickLoadDataButton();
        homePage.sleepInSecond(3);

        homePage.enterTextboxByIndex("4","Contact Person", "Michael Jackson");
        homePage.sleepInSecond(3);

        homePage.enterTextboxByIndex("2","Company", "MJ Company");
        homePage.sleepInSecond(3);

        homePage.enterTextboxByIndex("3","Order Placed", "881");
        homePage.sleepInSecond(3);

        homePage.selectDropdownByIndex("6","Country", "Hong Kong");
        homePage.sleepInSecond(2);
        homePage.selectDropdownByIndex("8","Country", "United Kingdom");
        homePage.sleepInSecond(2);


        homePage.selectCheckboxByIndex("5","NPO?",true);
        homePage.sleepInSecond(3);
        homePage.selectCheckboxByIndex("6","NPO?",false
        );
        homePage.sleepInSecond(3);

        homePage.clickIconByIndex("8","Move Up");
        homePage.sleepInSecond(3);
        homePage.clickIconByIndex("6","Remove");
        homePage.sleepInSecond(3);
        homePage.clickIconByIndex("6","Insert");
        homePage.sleepInSecond(3);

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private HomePageObject homePage;




}
