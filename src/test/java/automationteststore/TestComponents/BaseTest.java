package automationteststore.TestComponents;

import automationteststore.helper.assertion.VerificationHelper;
import automationteststore.helperutilities.GlobalVars;
import automationteststore.pageObjects.HomePages.HomePage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    VerificationHelper verificationHelper;
    public HomePage homePage;
    public WebDriver initializeDriver() throws IOException {
        // properties class
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//main//java//automationteststore//resources//GlobalData.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-dev-shm-usage");
            ops.addArguments("--no-sandbox");
            ops.addArguments("--window-size=1920,1080");
            ops.addArguments("--disable-extensions");
            ops.addArguments("--start-maximized");
            ops.addArguments("--disable-gpu");
            ops.addArguments("--whitelisted-ips");
            ops.addArguments("--ignore-certificate-errors");
            //ops.addArguments("--headless");
            ops.addArguments("--test-type");
            ops.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(ops);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/benaz//documents//geckodriver");
            driver = new FirefoxDriver();
            // Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.implicitWait));
        driver.manage().window().maximize();
        return driver;

    }
    public String getApplicationUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//automationteststore//resources//GlobalData.properties");
        prop.load(data);
        return prop.getProperty("applicationUrl");
    }
    public void takeSnapShot(WebDriver webdriver) throws IOException {
        File srcFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "\\target\\screenShots" + timestamp() + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }
    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
        //String to HashMap- Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        //{MapScream, MapScream}
    }
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }
    @BeforeMethod(alwaysRun = true)
    public HomePage launchApplication() throws IOException {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        homePage.navigateToUrl(getApplicationUrl());
        return homePage;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}