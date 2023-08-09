package automationteststore.pageObjects;

import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Page {
    public WebDriver driver;


    Logger log = LoggerHelper.getLogger(AccountEditPage.class);
    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}


