package commons;

import java.io.File;

public class GlobalConstants {
    //system information
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    //wait for
    public static final short SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    //App for user
    public static final String USER_URL ="https://localhost:59579";

    //App for admin

    public static final String ADMIN_URL = "https://localhost:59579/admin";

    //Browser Extension/log:
    public static final String BROWSER_EXTENSION_PATH =PROJECT_PATH+SEPARATOR+"browserExtensions"+SEPARATOR;
    public static final String BROWSER_LOG_PATH = PROJECT_PATH +SEPARATOR+"browserLogs"+SEPARATOR;

    //upload/download file:

    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR +"uploadFile"+SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR +"downloadFile"+SEPARATOR;

    //html Report Folder

    public static final String REPORTNG_PATH = PROJECT_PATH +SEPARATOR+"htmlReportNG"+SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH +SEPARATOR+"htmlExtent"+SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH +SEPARATOR + "htmlAllure" +SEPARATOR;



    // Data test/Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR +"testData"+SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH +SEPARATOR+"environmentConfig"+SEPARATOR;



    //Orange HRM

    public static final String HRM_ADMIN_USERNAME = "Automation_tester";
    public static final String HRM_ADMIN_PASSWORD = "Mocnguyen2002@";


}
