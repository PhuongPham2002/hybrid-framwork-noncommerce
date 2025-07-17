package orangeHRM.PIM;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM_02_Employee extends BaseTest { // Tách làm 2 class thì nhược điểm là dữ liệu test phải tạo lại và ko test đc liên tục
    // ưu điểm là chạy nhanh hơn, ko bị fail hàng loạt
    private WebDriver driver;

    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String urlValue,String browserName) {
        driver = getBrowserDriver(urlValue, browserName);
    // Add new user
    }

    @Test
    public void Employee_07_Immigration() {}

    public void Employee_08_Job() {}

    public void Employee_09_Salary() {}

    public void Employee_10_Tax() {}

    public void Employee_11_Qualifications() {}


    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }

}
