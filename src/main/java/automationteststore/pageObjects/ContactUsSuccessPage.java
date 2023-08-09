package automationteststore.pageObjects;

import automationteststore.pages.Page;
import automationteststore.helper.actiondriver.Action;
import automationteststore.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ContactUsSuccessPage extends Page {
    public WebDriver driver;

    public static final Logger log = LoggerHelper.getLogger(ContactUsSuccessPage.class);
    Action act = new Action();

    public ContactUsSuccessPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".mb40 > p:nth-of-type(2)")
    WebElement successfullySentMsg;

    @FindBy(css= ".mb40 > a[title='Continue']")
    WebElement continueBtn;
    public String successfullySentMsg() {
        return this.successfullySentMsg.getText();
    }
    public WebElement continueBtn() {
        return this.continueBtn;
    }

}



