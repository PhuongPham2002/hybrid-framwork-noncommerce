package javaBasic;

import java.io.File;

public class SystemInformation {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        //System.out.println(osName);
        String projectPath = System.getProperty("user.dir");
        //System.out.println(projectPath);

        System.out.println(System.getProperty("file.separator"));

        //E:\Automation Testing\02_Selenium WebDriver\hybrid-framwork-noncommerce
        String haLongImagePath = projectPath + File.separator+ "uploadFile" + File.separator + "Ha Long.jpg";  // nếu dùng 1 \ thì java hiểu là bỏ qua dầu "" nên cần dùng là \\
        System.out.println(haLongImagePath);
    }
}
