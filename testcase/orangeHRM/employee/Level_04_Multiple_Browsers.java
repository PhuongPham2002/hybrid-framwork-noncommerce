package orangeHRM.employee;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;

public class Level_04_Multiple_Browsers extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    String username, password;
    private DashboardPageObject dashboardPage;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue,String browserName) {
        driver = getBrowserDriver(urlValue, browserName);
        loginPage = new LoginPageObject(driver);
        username ="Admin";
        password ="admin123";
    }
    @Test
    public void TC_01_Login() {
        loginPage.enterUsernameTextbox(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPageObject(driver);
    }
    @Test
    public void TC_02_New_Employee() {



    }

    @Test
    public void TC_03_MyAccount_Personal_Detail() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }




}
