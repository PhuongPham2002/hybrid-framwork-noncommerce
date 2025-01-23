package commons;

import java.io.File;

public class GlobalConstants {
    //system information
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    //wait for
    public static final short SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;

    //App for user
    public static final String USER_URL ="https://localhost:59579";

    //App for admin

    public static final String ADMIN_URL = "https://localhost:59579/admin";

    //upload/download file:

    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR +"uploadFile"+SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR +"downloadFile"+SEPARATOR;

    //html Report Folder


    // Data test/Environment

}
