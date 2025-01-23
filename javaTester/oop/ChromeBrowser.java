package oop;

import org.openqa.selenium.chromium.ChromiumDriver;

/**
 * 1 class có thể kế thừa 1 class (extends), hoặc 1 hoặc nhiều interface (implements)
 * <br> Một class chỉ được kế thừa 1 class, và được kế thừa nhiều interface
 * <br> Một interface kế thừa 1 interface
 */
public class ChromeBrowser extends Browser implements IBrowser {
    ChromiumDriver chromiumDriver;

    // không cần viết lại code, kế thừa các class khác là đc. (kế thừa các phương thức, thuộc tnhs)
    public void endUser () {
        openUrl();
        back();
        refresh();
        System.out.println(browserVersion);

    }

    @Override
    public void openUrl() {
        chromiumDriver.deleteNetworkConditions(); // các thư viện delete.. đã được đóng gói để sử dụng.

    }

    @Override
    public void back() {

    }

    @Override
    public void forward() {

    }

    @Override
    public void refresh() {

    }

}
