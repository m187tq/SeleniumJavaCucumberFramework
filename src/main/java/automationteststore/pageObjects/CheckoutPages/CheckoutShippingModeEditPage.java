package automationteststore.pageObjects.CheckoutPages;

import automationteststore.pages.Page;
import automationteststore.helper.logger.LoggerHelper;
import automationteststore.pageObjects.AccountEditPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutShippingModeEditPage extends Page {
    public WebDriver driver;
    Logger log = LoggerHelper.getLogger(AccountEditPage.class);
    public CheckoutShippingModeEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}