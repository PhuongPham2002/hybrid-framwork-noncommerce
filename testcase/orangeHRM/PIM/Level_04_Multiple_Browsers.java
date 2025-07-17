package orangeHRM.PIM;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;

public class Level_04_Multiple_Browsers extends BaseTest {
    private WebDriver driver;
    private LoginPO loginPage;
    String username, password;
    private DashboardPO dashboardPage;

    public Level_04_Multiple_Browsers() {
        super();
    }

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue,String browserName) {
        driver = getBrowserDriver(urlValue, browserName);
        loginPage = new LoginPO(driver);
        username ="Admin";
        password ="admin123";
    }
    @Test
    public void TC_01_Login() {
        loginPage.enterUsernameTextbox(username);
        loginPage.enterPasswordTextbox(password);
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPO(driver);
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
