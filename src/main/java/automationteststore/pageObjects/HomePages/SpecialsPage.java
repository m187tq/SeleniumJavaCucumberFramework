package automationteststore.pageObjects.HomePages;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.AccountLoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SpecialsPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(HomePage.class);
    AccountLoginPage accountLoginPage;
    public SpecialsPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}