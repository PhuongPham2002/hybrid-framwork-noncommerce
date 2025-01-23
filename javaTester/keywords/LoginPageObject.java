package keywords;

/**
 * extends - tính kế thừa. Khi 1 class kế thừa 1 class --> thăng class này sẽ kế thừa các thuộc tính, phương thức của thằng kia.
 * <br>
 *
 */

public class LoginPageObject extends BasePage {
    //Global variable
    String browserName;
    public LoginPageObject(String browserName){
        //Để gọi qua constructor của lớp cha
        super(browserName);

    }
    @Override
    public boolean isPageDisplayed() {
        //Local variable
        String browserName ="Chrome";
        System.out.println(browserName);// Sẽ ưu tiên in biến cục bộ hơn
        //Block Code
        if(browserName.equals("Chrome")) {
            String fullName = "";
        }
        System.out.println(this.browserName); //Muốn lấy biến global, ko phải local thì sử dụng this
        return false;
    }
}
