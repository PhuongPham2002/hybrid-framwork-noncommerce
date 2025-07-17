package orangeHRM.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.employee.AddNewPO;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageObjects.orangeHRM.pim.employee.PersonalDetailsPO;
import ultilities.FakerConfig;

public class Level_24_Data_Faker extends BaseTest {

    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddNewPO addNewPage;
    private PersonalDetailsPO personalDetailsPage;
    private String employeeID;
    private String firstName, lastName,editFirstname, editLastName,driverLicense,expiryDate,nation,maritalStatus,dateOfBirth;
    private String avatarImageName ="1MB.jpg";
    private FakerConfig faker;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue,String browserName) {
        driver = getBrowserDriver(urlValue, browserName);
        driver.manage().window().maximize();
        loginPage = PageGenerator.getLoginPage(driver);
        faker = FakerConfig.getFaker();
        loginPage.enterUsernameTextbox(GlobalConstants.HRM_ADMIN_USERNAME);
        loginPage.enterPasswordTextbox(GlobalConstants.HRM_ADMIN_PASSWORD);
        dashboardPage = loginPage.clickLoginButton();
        firstName = faker.getFirstName();
        lastName = faker.getLastName();
        editFirstname =faker.getFirstName();
        editLastName =faker.getLastName();
        driverLicense = "123456789";
        expiryDate = "2026-03-06";
        nation = "Algerian";
        maritalStatus ="Single";
        dateOfBirth = "2000-09-10";
    }

    @Test
    public void Employee_01_Add_New () {
        //Wait cho tất cả loading icon biến mất
        employeeListPage = dashboardPage.clickPIMPage();
        addNewPage = employeeListPage.clickAddEmployeeButton();
        employeeListPage.waitAllLoadingIconInvisible(driver);
        addNewPage.enterFirstnameTextbox (firstName);
        addNewPage.enterLastnameTextbox (lastName);
        employeeID = addNewPage.getEmployeeID();
        System.out.println("Employee ID: "+ employeeID);//sử dụng cho các chức năng sau
        personalDetailsPage = addNewPage.clickSaveButtonEmployeeContainer();
        //Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
    }

    @Test
    public void Employee_02_Upload_Avatar() {
        personalDetailsPage.clickAvatarImage();
        Dimension beforeUpload = personalDetailsPage.getAvatarSize();
        System.out.println("Size:" + beforeUpload);
        personalDetailsPage.uploadMultipleFiles(driver,avatarImageName);
        personalDetailsPage.clickSaveButtonAtProfilePictureContainer();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);
        Assert.assertTrue(personalDetailsPage.isProfileAvatarUpdateSuccessful(beforeUpload));

    }
    @Test
    public void Employee_03_Personal_Details() {
        personalDetailsPage.openPersonalDetailsPage("Personal Details");
        personalDetailsPage.enterFirstNameTextbox(editFirstname);
        personalDetailsPage.enterLastNameTextbox(editLastName);
        System.out.println("employeeID new: " + personalDetailsPage.getEmployeeID());
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        personalDetailsPage.enterDriverLicenseTextbox(driverLicense);
        personalDetailsPage.enterExpiryDateTextbox(expiryDate);
        personalDetailsPage.selectNationalityDropdown(nation);
        personalDetailsPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.enterDateOfBirthTextbox(dateOfBirth);
        personalDetailsPage.selectGenderFemaleRadio();
        personalDetailsPage.clickSaveButtonAtPersonalDetailContainer();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed(driver));
        personalDetailsPage.waitAllLoadingIconInvisible(driver);

        //Verify lại hêt các thông tin đã thay đổi
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(),editFirstname);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(),editLastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        Assert.assertEquals(personalDetailsPage.getDriverLicenseTextbox(),driverLicense);
        Assert.assertEquals(personalDetailsPage.getExpiryDateTextbox(),expiryDate);
        Assert.assertEquals(personalDetailsPage.getNationalityDropdown(),nation);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdown(),maritalStatus);
        Assert.assertEquals(personalDetailsPage.getDateOfBirthTextbox(),dateOfBirth);
        Assert.assertTrue(personalDetailsPage.isGenderFemaleSelected());

    }
    @Test
    public void Employee_04_Contact_Details() {}
    @Test
    public void Employee_05_Emergency_Details() {}
    @Test
    public void Employee_06_Assigned_Dependents() {}

    @AfterClass (alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
