package automationteststore.helperutilities;

public class GlobalVars {
    /**
     * Config Properties file
     **/
    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";
    public final static String URL_HOMEPAGE = "https://automationteststore.com/";

    public final static String RETURNING_CUSOTMER = "Returning Customer";
    public final static String NEW_CUSTOMER = "I am a new customer.";

    public final static String WELCOME_MSG = "Welcome back";
    public final static String REGISTER_JSON_PATH = "//src//test//java//automationteststore//data//createAnAccount.json";

    public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\geckodriver.exe";

    public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\chromedriver.exe";

    public final static String IE_DRIVER_DIRECTORY = System.getProperty("user.dir") + "src\\main\\java\\driver\\IEDriverServer.exe";

    public final static String userName = "datastudioplace";
    public final static String password = "Manchester1";

    public final static String HOMEPAGE_TITLE = "A place to practice your automation skills!";
    public final static String ACCOUNT_LOGOUT_HEADER = "ACCOUNT LOGOUT";
    public final static String ACCOUNT_EDIT_URLPATH = "account/edit";
    public final static String PRODUCTNAME_1 = "SKINSHEEN BRONZER STICK";
    public final static String PRODUCTNAME_2 = "BENEFIT BELLA BAMBA";
    public final static String PRODUCTNAME_3 = "ABSOLUE EYE PRECIOUS CELLS";

    public static String getSkinBronzerStick() {
        return PRODUCTNAME_1;
    }
    public static String getBenefitBellaBamba() {
        return PRODUCTNAME_2;
    }
    public static String getAbsolueEyePreciousCells() {
        return PRODUCTNAME_3;
    }

    public final static int explicitWait = 10;
    public final static int DEFAULT_EXPLICIT_TIMEOUT = 10;
    public final static int DEFAULT_IMPLICIT_TIMEOUT = 7;
    public final static int implicitWait = 5;

    private final static String UPDATED_SUCCESFULLY = "Success: Your account has been successfully updated";
    public static String getConfigPropertiesDirectory(){
        return CONFIG_PROPERTIES_DIRECTORY;
    }

    public static String getGeckoDriverDirectory() {
        return GECKO_DRIVER_DIRECTORY;
    }
    public static String getHomePageTitle() {
        return HOMEPAGE_TITLE;
    }
    public static String getAccountEditUrlpath() {
        return ACCOUNT_EDIT_URLPATH;
    }

    public static String getRegisterJsonPath() {
        return REGISTER_JSON_PATH;
    }


    public static String getHomePageUrl() {
        return URL_HOMEPAGE;
    }

    public static String getChromeDriverDirectory() {
        return CHROME_DRIVER_DIRECTORY;
    }

    public static String getIeDriverDirectory() {
        return IE_DRIVER_DIRECTORY;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getReturningCustomer() {
        return RETURNING_CUSOTMER;
    }
    public static String getNewCustomer() {
        return NEW_CUSTOMER;
    }
    public static String getWelcomeMsg() {
        return WELCOME_MSG;
    }

    public static int getExplicitWait() {
        return explicitWait;
    }

    public static int getImplicitWait() {
        return implicitWait;
    }

    public static int getDefaultExplicitTimeout() {
        return DEFAULT_EXPLICIT_TIMEOUT;
    }

    public static int getDefaultImplicitTimeout() {
        return DEFAULT_IMPLICIT_TIMEOUT;
    }

    public static String getUpdatedSuccessfully() {
        return UPDATED_SUCCESFULLY;}

    public static String getAccountLogoutHeaderTxt() {
    return ACCOUNT_LOGOUT_HEADER;}
}

